let medicineHistory = [];
let editingScheduleItem = null;

// 現在の日時を更新
function updateDateTime() {
            const now = new Date();
            const year = now.getFullYear();
            const month = String(now.getMonth() + 1).padStart(2, '0');
            const day = String(now.getDate()).padStart(2, '0');
            const hours = String(now.getHours()).padStart(2, '0');
            const minutes = String(now.getMinutes()).padStart(2, '0');
            
            document.getElementById('datetime').textContent = `${year}.${month}.${day} ${hours}:${minutes}`;
        }

        // 1秒ごとに時刻を更新
        setInterval(updateDateTime, 1000);
        updateDateTime();

        // タブ切り替え
        function switchTab(tabName) {
            // すべてのタブを非アクティブにする
            document.querySelectorAll('.tab').forEach(tab => tab.classList.remove('active'));
            document.querySelectorAll('.medicine-list').forEach(list => list.style.display = 'none');

            // 選択したタブをアクティブにする
            event.target.classList.add('active');
            document.getElementById(tabName).style.display = 'block';

            // 履歴タブの場合、履歴を更新
            if (tabName === 'history') {
                updateMedicineHistory();
            }
        }

        // 服薬チェック
        function markAsTaken(checkbox, medicineName, time) {
            if (checkbox.checked) {
                const now = new Date();
                const timestamp = now.toLocaleString('ja-JP');
                
                medicineHistory.push({
                    name: medicineName,
                    time: time,
                    takenAt: timestamp
                });

                // チェックボックスを無効にする
                checkbox.disabled = true;
                
                alert(`${medicineName}(${time})の服薬を記録しました。`);
            }
        }

        // 服薬履歴を更新
        function updateMedicineHistory() {
            const historyContainer = document.getElementById('medicineHistory');
            historyContainer.innerHTML = '';

            if (medicineHistory.length === 0) {
                historyContainer.innerHTML = '<div style="text-align: center; color: #999; padding: 20px;">服薬履歴がありません</div>';
                return;
            }

            medicineHistory.forEach(record => {
                const historyItem = document.createElement('div');
                historyItem.className = 'history-item';
                historyItem.innerHTML = `
                    <div><strong>${record.name}</strong> (${record.time})</div>
                    <div style="font-size: 11px; color: #666;">服薬時刻: ${record.takenAt}</div>
                `;
                historyContainer.appendChild(historyItem);
            });
        }

        // 薬を削除
        function removeMedicine(button) {
            if (confirm('この薬を削除しますか？')) {
                button.closest('.medicine-item').remove();
            }
        }

        // 薬追加モーダルを表示
        function showAddMedicineModal() {
            document.getElementById('addMedicineModal').style.display = 'block';
        }

        // スケジュール追加モーダルを表示
        function showAddScheduleModal() {
            document.getElementById('scheduleModalTitle').textContent = 'スケジュール追加';
            document.getElementById('scheduleSubmitBtn').textContent = '追加';
            document.getElementById('addScheduleForm').reset();
            editingScheduleItem = null;
            document.getElementById('addScheduleModal').style.display = 'block';
        }

        // モーダルを閉じる
        function closeModal(modalId) {
            document.getElementById(modalId).style.display = 'none';
        }

        // スケジュール編集
        function editSchedule(button) {
            const scheduleItem = button.closest('.schedule-item');
            const time = scheduleItem.querySelector('.schedule-time').textContent;
            const content = scheduleItem.querySelector('.schedule-content').textContent;

            document.getElementById('scheduleTime').value = time;
            document.getElementById('scheduleContent').value = content;
            document.getElementById('scheduleModalTitle').textContent = 'スケジュール編集';
            document.getElementById('scheduleSubmitBtn').textContent = '更新';
            
            editingScheduleItem = scheduleItem;
            document.getElementById('addScheduleModal').style.display = 'block';
        }

        // スケジュール削除
        function removeSchedule(button) {
            if (confirm('このスケジュールを削除しますか？')) {
                button.closest('.schedule-item').remove();
            }
        }

        // 薬追加フォーム送信
        document.getElementById('addMedicineForm').addEventListener('submit', function(e) {
            e.preventDefault();
            
            const name = document.getElementById('medicineName').value;
            const dose = document.getElementById('medicineDose').value;
            const time = document.getElementById('medicineTime').value;
            
            const medicineItem = document.createElement('div');
            medicineItem.className = 'medicine-item';
            medicineItem.innerHTML = `
                <div class="medicine-info">
                    <div class="medicine-name">${name}</div>
                    <div class="medicine-dose">${dose}</div>
                </div>
                <div class="medicine-actions">
                    <input type="checkbox" class="checkbox" onchange="markAsTaken(this, '${name}', '${time === 'morning' ? '朝' : time === 'noon' ? '昼' : '晩'}')">
                    <button class="btn btn-small btn-danger" onclick="removeMedicine(this)">削除</button>
                </div>
            `;
            
            document.getElementById(time).appendChild(medicineItem);
            closeModal('addMedicineModal');
            this.reset();
        });

        // スケジュール追加/編集フォーム送信
        document.getElementById('addScheduleForm').addEventListener('submit', function(e) {
            e.preventDefault();
            
            const time = document.getElementById('scheduleTime').value;
            const content = document.getElementById('scheduleContent').value;
            
            if (editingScheduleItem) {
                // 編集モード
                editingScheduleItem.querySelector('.schedule-time').textContent = time;
                editingScheduleItem.querySelector('.schedule-content').textContent = content;
            } else {
                // 追加モード
                const scheduleItem = document.createElement('div');
                scheduleItem.className = 'schedule-item';
                scheduleItem.innerHTML = `
                    <div class="schedule-time">${time}</div>
                    <div class="schedule-content">${content}</div>
                    <div class="schedule-actions">
                        <button class="btn btn-small" onclick="editSchedule(this)">編集</button>
                        <button class="btn btn-small btn-danger" onclick="removeSchedule(this)">削除</button>
                    </div>
                `;
                
                // 時間順にソートして挿入
                const scheduleList = document.getElementById('scheduleList');
                const scheduleItems = Array.from(scheduleList.children);
                
                let inserted = false;
                for (let i = 0; i < scheduleItems.length; i++) {
                    const existingTime = scheduleItems[i].querySelector('.schedule-time').textContent;
                    if (time < existingTime) {
                        scheduleList.insertBefore(scheduleItem, scheduleItems[i]);
                        inserted = true;
                        break;
                    }
                }
                
                if (!inserted) {
                    scheduleList.appendChild(scheduleItem);
                }
            }
            
            closeModal('addScheduleModal');
            this.reset();
        });

        // モーダルの外側をクリックして閉じる
        document.querySelectorAll('.modal').forEach(modal => {
            modal.addEventListener('click', function(e) {
                if (e.target === this) {
                    closeModal(this.id);
                }
            });
        });
        
     // モーダル関連の関数
        function openAddModal() {
            document.getElementById('addModal').style.display = 'block';
            document.getElementById('handoverContent').focus();
        }

        function closeAddModal() {
            document.getElementById('addModal').style.display = 'none';
            document.getElementById('addHandoverForm').reset();
        }

        function openHistoryModal() {
            document.getElementById('historyModal').style.display = 'block';
            loadHistory();
        }

        function closeHistoryModal() {
            document.getElementById('historyModal').style.display = 'none';
        }

        // モーダル外クリックで閉じる
        window.onclick = function(event) {
            const addModal = document.getElementById('addModal');
            const historyModal = document.getElementById('historyModal');
            if (event.target === addModal) {
                closeAddModal();
            }
            if (event.target === historyModal) {
                closeHistoryModal();
            }
        }

        // フォーム送信処理
        document.getElementById('addHandoverForm').addEventListener('submit', function(e) {
            e.preventDefault();
            
            const content = document.getElementById('handoverContent').value.trim();
            if (!content) {
                alert('申し送り内容を入力してください。');
                return;
            }

            // サーバーに送信
            addHandover(content);
        });

        // 申し送り事項追加
        function addHandover(content) {
            // TODO: ここでサーブレットにPOSTリクエストを送信
            fetch('HandoverServlet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: 'action=add&content=' + encodeURIComponent(content)
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert('申し送り事項を追加しました。');
                    closeAddModal();
                    loadLatestHandover(); // 最新の申し送り事項を再読み込み
                } else {
                    alert('エラーが発生しました: ' + data.message);
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('エラーが発生しました。');
            });
        }

        // 最新の申し送り事項読み込み
        function loadLatestHandover() {
            fetch('HandoverServlet?action=latest')
            .then(response => response.json())
            .then(data => {
                const container = document.getElementById('latestHandover');
                if (data.success && data.handover) {
                    const handover = data.handover;
                    container.innerHTML = `
                        <div class="handover-item">
                            <div class="handover-content">${escapeHtml(handover.content)}</div>
                            <div class="handover-meta">
                                ${handover.createdDate} - ${escapeHtml(handover.createdBy)}
                            </div>
                        </div>
                    `;
                } else {
                    container.innerHTML = '<div class="no-handover">申し送り事項がありません</div>';
                }
            })
            .catch(error => {
                console.error('Error:', error);
                document.getElementById('latestHandover').innerHTML = 
                    '<div class="no-handover">データの読み込みに失敗しました</div>';
            });
        }

        // 履歴読み込み
        function loadHistory() {
            fetch('HandoverServlet?action=history')
            .then(response => response.json())
            .then(data => {
                const container = document.getElementById('historyList');
                if (data.success && data.handovers && data.handovers.length > 0) {
                    let html = '';
                    data.handovers.forEach(handover => {
                        html += `
                            <div class="history-item">
                                <div class="history-content">${escapeHtml(handover.content)}</div>
                                <div class="history-meta">
                                    <span>${handover.createdDate}</span>
                                    <span>${escapeHtml(handover.createdBy)}</span>
                                </div>
                            </div>
                        `;
                    });
                    container.innerHTML = html;
                } else {
                    container.innerHTML = '<div style="text-align: center; color: #999;">申し送り事項の履歴がありません</div>';
                }
            })
            .catch(error => {
                console.error('Error:', error);
                document.getElementById('historyList').innerHTML = 
                    '<div style="text-align: center; color: #999;">データの読み込みに失敗しました</div>';
            });
        }

        // HTMLエスケープ関数
        function escapeHtml(text) {
            const div = document.createElement('div');
            div.textContent = text;
            return div.innerHTML;
        }

        // ページ読み込み時に最新の申し送り事項を取得
        document.addEventListener('DOMContentLoaded', function() {
            loadLatestHandover();
        });
        
        // 病歴モーダル
        function closehistoryModal(id) {
          document.getElementById(id).style.display = 'none';
        }
        
        function showAddhistoryModal() {
        	  const modal = document.getElementById('addhistoryModal');
        	  if (modal) {
        	    modal.style.display = 'block';
        	  }
        	}


        
        const showAddhistoryModalBtn = document.getElementById('showAddhistoryModal');
        const closehistoryModalBtn = document.getElementById('closehistoryModal');
        const addhistoryModal = document.getElementById('addhistoryModal');

        // モーダルを開く
        showAddhistoryModalBtn.addEventListener('click', () => {
          addhistoryModal.style.display = 'block';
        });

        // モーダルを閉じる
        closehistoryModalBtn.addEventListener('click', () => {
          addhistoryModal.style.display = 'none';
        });

        // モーダル外をクリックして閉じる
        window.addEventListener('click', (e) => {
          if (e.target === addhistoryModal) {
            addhistoryModal.style.display = 'none';
          }
        });

        // アレルギーモーダル
        function closeallergyModal(id) {
          document.getElementById(id).style.display = 'none';
        }
        
        function showAddallergyModal() {
        	  const modal = document.getElementById('addallergyModal');
        	  if (modal) {
        	    modal.style.display = 'block';
        	  }
        	}


        
        const showAddallergyModalBtn = document.getElementById('showAddallergyModal');
        const closeallergyModalBtn = document.getElementById('closeallergyModal');
        const addallergyModal = document.getElementById('addallergyModal');

        // モーダルを開く
        showAddallergyModalBtn.addEventListener('click', () => {
          addallergyModal.style.display = 'block';
        });

        // モーダルを閉じる
        closeallergyModalBtn.addEventListener('click', () => {
          addallergyModal.style.display = 'none';
        });

        // モーダル外をクリックして閉じる
        window.addEventListener('click', (e) => {
          if (e.target === addallergyModal) {
            addallergyModal.style.display = 'none';
          }
        });

     // 身体測定モーダル
        function closemeasurementsModal(id) {
          document.getElementById(id).style.display = 'none';
        }
        
        function showAddmeasurementsModal() {
        	  const modal = document.getElementById('addmeasurementsModal');
        	  if (modal) {
        	    modal.style.display = 'block';
        	  }
        	}


        
        const showAddmeasurementsModalBtn = document.getElementById('showAddmeasurementsModal');
        const closemeasurementsModalBtn = document.getElementById('closemeasurementsModal');
        const addmeasurementsModal = document.getElementById('addmeasurementsModal');

        // モーダルを開く
        showAddmeasurementsModalBtn.addEventListener('click', () => {
          addmeasurementsModal.style.display = 'block';
        });

        // モーダルを閉じる
        closemeasurementsModalBtn.addEventListener('click', () => {
          addmeasurementsModal.style.display = 'none';
        });

        // モーダル外をクリックして閉じる
        window.addEventListener('click', (e) => {
          if (e.target === addmeasurementsModal) {
            addmeasurementsModal.style.display = 'none';
          }
        });

        //申し送り事項
        function closecareModal(id) {
            document.getElementById(id).style.display = 'none';
          }
          
          function showAddcareModal() {
          	  const modal = document.getElementById('addcareModal');
          	  if (modal) {
          	    modal.style.display = 'block';
          	  }
          	}


          
          const showAddcareModalBtn = document.getElementById('showAddcareModal');
          const closecareModalBtn = document.getElementById('closecareModal');
          const addcareModal = document.getElementById('addcareModal');

          // モーダルを開く
          showAddcareModalBtn.addEventListener('click', () => {
            addcareModal.style.display = 'block';
          });

          // モーダルを閉じる
          closecareModalBtn.addEventListener('click', () => {
            addcareModal.style.display = 'none';
          });

          // モーダル外をクリックして閉じる
          window.addEventListener('click', (e) => {
            if (e.target === addcareModal) {
              addcareModal.style.display = 'none';
            }
          });
        
        document.addEventListener('DOMContentLoaded', () => {
        	  const form = document.getElementById('careForm');
        	  const list = document.getElementById('selectedCareList');

        	  form.addEventListener('submit', (event) => {
        	    event.preventDefault();

        	    const checkedItems = Array.from(form.elements['care'])
        	      .filter(item => item.checked)
        	      .map(item => item.value);

        	    // 表示を更新
        	    list.innerHTML = '';
        	    checkedItems.forEach(care => {
        	      const item = document.createElement('div');
        	      item.textContent = care;
        	      list.appendChild(item);
        	    });
        	  });
        	});

//介助レベル
        
          
          function showAddlevelModal() {
          	  const modal = document.getElementById('addlevelModal');
          	  if (modal) {
          	    modal.style.display = 'block';
          	  }
          	}


          
          const showAddlevelModalBtn = document.getElementById('showAddlevelModal');
          const addlevelModal = document.getElementById('addlevelModal');

          // モーダルを開く
          showAddlevelModalBtn.addEventListener('click', () => {
            addlevelModal.style.display = 'block';
          });

         
        
        //ボックスクリックで保存
        document.querySelectorAll('#addlevelModal .modalabel-content')
        .forEach(el => {
          el.style.cursor = 'pointer';
          el.addEventListener('click', async () => {
        	  const level = el.dataset.level;  // "レベル１" を取得
        	  await saveLevel(level);
        	  document.getElementById('addlevelModal').style.display = 'none';
        	});
        });
