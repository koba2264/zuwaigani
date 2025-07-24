<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>診療録</title>
<link rel="stylesheet" href="/zuwaigani/css/medrec.css">
</head>
<body>
	<!-- 上半分 -->
	<div class="upper-half">
		<!--入居者情報（名前等）-->
		<div class="Information-box">
			<div class="vertical">
				<div class="beide">
					<p>入居日：</p>
					<p>2024-10-01</p>
				</div>
				<h3>大原 満 様</h3>
			</div>
			<!-- 区分・誕生日 -->
			<div class="vertical">
				<h4>入居</h4>
				<p>1979-11-01</p>
			</div>
			<!-- 部屋番号 -->
			<div class="vertical">
				<h3>部屋番号</h3>
				<h3>A-201</h3>
			</div>
			<!-- 連作先一覧 -->
			<div class="vertical">
				<div class="beside">
					<p>連絡先</p>
					<p>080-9999-9999</p>
				</div>
				<div class="beside">
					<p>緊急連絡先１</p>
					<p>000-0000-0000</p>
				</div>
				<div class="beside">
					<p>緊急連絡先２</p>
					<p></p>
				</div>
			</div>
		</div>
		<!-- 今日の日付等 -->
		<div class="today">
			<div class="vertical">
				<p>2024.12.24</p>
				<h3>20:009</h3>
			</div>
			<h4>火</h4>
		</div>
	</div>
	<!-- 下半分 -->
	<div class="lower-half">
		<!-- 処方箋一覧 -->
		<div class="prescription">
			<div class="container">
				<div class="header">
					<div class="nav-tabs">
						<button class="nav-tab active" onclick="showTimeperiod('morning')">朝</button>
						<button class="nav-tab" onclick="showTimeperiod('noon')">昼</button>
						<button class="nav-tab" onclick="showTimeperiod('evening')">夜</button>
						<button class="nav-tab" onclick="showHistory()">履歴</button>
					</div>
				</div>

				<div class="content">
					<!-- 朝の薬 -->
					<div id="morning" class="time-period active">
						<div class="period-header">
							<h2 class="period-title">朝の投薬</h2>
							<button class="add-btn" onclick="openAddModal('morning')">
								+ 薬を追加</button>
						</div>
						<div id="morning-medications"></div>
					</div>

					<!-- 昼の薬 -->
					<div id="noon" class="time-period">
						<div class="period-header">
							<h2 class="period-title">昼の投薬</h2>
							<button class="add-btn" onclick="openAddModal('noon')">
								+ 薬を追加</button>
						</div>
						<div id="noon-medications"></div>
					</div>

					<!-- 夜の薬 -->
					<div id="evening" class="time-period">
						<div class="period-header">
							<h2 class="period-title">夜の投薬</h2>
							<button class="add-btn" onclick="openAddModal('evening')">
								+ 薬を追加</button>
						</div>
						<div id="evening-medications"></div>
					</div>

					<!-- 履歴 -->
					<div id="history" class="history">
						<div class="period-header">
							<h2 class="period-title">服薬履歴</h2>
						</div>
						<div id="history-list"></div>
					</div>
				</div>
			</div>

			<!-- 薬追加・編集モーダル -->
			<div id="medicationModal" class="modal">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title">薬の設定</h3>
						<button class="close" onclick="closeModal()">&times;</button>
					</div>
					<form id="medicationForm">
						<div class="form-group">
							<label>薬名</label> <input type="text" id="medicationName" required>
						</div>
						<div class="form-group">
							<label>投薬タイミング</label> <select id="medicationTiming">
								<option value="食前">食前</option>
								<option value="食後">食後</option>
								<option value="食間">食間</option>
								<option value="就寝前">就寝前</option>
								<option value="起床時">起床時</option>
							</select>
						</div>
						<div class="form-group">
							<label>用量</label> <input type="text" id="dosage"
								placeholder="例: 2錠、20mg、1包">
						</div>
						<div class="form-group">
							<label>種類</label> <select id="medicationType">
								<option value="錠剤">錠剤</option>
								<option value="液体">液体</option>
								<option value="粉薬">粉薬</option>
								<option value="カプセル">カプセル</option>
							</select>
						</div>
						<div class="form-group">
							<label>服用時間帯</label>
							<div class="time-settings">
								<div class="time-checkbox">
									<input type="checkbox" id="timeMorning" value="morning">
									<label for="timeMorning">朝</label>
								</div>
								<div class="time-checkbox">
									<input type="checkbox" id="timeNoon" value="noon"> <label
										for="timeNoon">昼</label>
								</div>
								<div class="time-checkbox">
									<input type="checkbox" id="timeEvening" value="evening">
									<label for="timeEvening">夜</label>
								</div>
							</div>
						</div>
						<div class="form-buttons">
							<button type="button" class="btn-secondary"
								onclick="closeModal()">キャンセル</button>
							<button type="submit" class="btn-primary">保存</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 右半分 -->
		<div class="right-box">
			<div class="column">
				<!-- 介助レベル -->
				<!-- これ編集ボタンじゃなくてそのままボタンにしてしまえばすっきりした見た目になりそう -->
				<div class="assistance-level">
					<i class="fas fa-exclamation-circle"></i>
					<h5>Ⅱ</h5>
					<p>介助レベル</p>
				</div>
				<!-- 申し送り事項 -->
				<div class="transfer">
					<h3>申し送り事項</h3>
					<!-- ここインプット追加する -->
				</div>
			</div>
			<!-- 注意事項 -->
			<div class="precautions">
				<!-- ここ後々完成させる -->
				<h3>注意事項</h3>

			</div>
			<div class="column">
				<!-- スケジュール -->
				<div class="schedule-box">
					<div class="schedule-widget">
						<div class="schedule-header">
							<div class="schedule-title">📅 スケジュール</div>
							<button class="add-btn-schedule" onclick="openModal()">+ 追加</button>
						</div>

						<div class="schedule-list">
							<div id="scheduleContainer"></div>
						</div>
					</div>

					<!-- モーダル -->
					<div class="schedule-overlay" id="modalOverlay"
						onclick="closeModal(event)">
						<div class="schedule-content" onclick="event.stopPropagation()">
							<div class="schedule-header">
								<h2 class="schedule-title">📋 新しい予定を追加</h2>
								<p style="color: #666; font-size: 14px;">時刻と内容を入力してください</p>
							</div>

							<div class="form-group-schedule">
								<label for="timeInput">時刻</label> <input type="time"
									id="timeInput" required>
							</div>

							<div class="form-group">
								<label for="contentInput">内容</label> <input type="text"
									id="contentInput" placeholder="予定を入力してください" required>
							</div>

							<div class="schedule-buttons">
								<button class="btn btn-primary-schedule" onclick="addSchedule()">追加</button>
								<button class="btn btn-secondary-schedule" onclick="closeModal()">キャンセル</button>
							</div>
						</div>
					</div>
				</div>
				<!-- アレルギー -->
				<div class="allergy-box"></div>
				<!-- 病歴 -->
				<div class="medical-history-box"></div>
				<!-- 身体測定 -->
				<div class="body-measurements-box"></div>
			</div>
		</div>
	</div>
	<script>
        // データ保存用
        let medications = {
            morning: [],
            noon: [],
            evening: []
        };
        
        let medicationHistory = [];
        let currentEditId = null;
        let currentTimeperiod = null;
        let schedules = [
            { time: "00:00", content: "スケジュール" },
            { time: "11:00", content: "非連打用" },
            { time: "14:30", content: "ソハピリ" },
            { time: "23:00", content: "真剣打合" }
        ];

        // 初期化
        document.addEventListener('DOMContentLoaded', function() {
            loadData();
            renderMedications();
            renderHistory();
        });

        // 時間帯切り替え
        function showTimeperiod(period) {
            // ボタンのアクティブ状態を更新
            document.querySelectorAll('.nav-tab').forEach(btn => btn.classList.remove('active'));
            event.target.classList.add('active');
            
            // コンテンツの表示切り替え
            document.querySelectorAll('.time-period, .history').forEach(el => el.classList.remove('active'));
            document.getElementById(period).classList.add('active');
        }

        // 履歴表示
        function showHistory() {
            document.querySelectorAll('.nav-tab').forEach(btn => btn.classList.remove('active'));
            event.target.classList.add('active');
            
            document.querySelectorAll('.time-period, .history').forEach(el => el.classList.remove('active'));
            document.getElementById('history').classList.add('active');
            renderHistory();
        }

        // 薬追加モーダルを開く
        function openAddModal(timeperiod) {
            currentTimeperiod = timeperiod;
            currentEditId = null;
            document.getElementById('medicationForm').reset();
            
            // 時間帯チェックボックスを設定
            document.getElementById('timeMorning').checked = timeperiod === 'morning';
            document.getElementById('timeNoon').checked = timeperiod === 'noon';
            document.getElementById('timeEvening').checked = timeperiod === 'evening';
            
            document.getElementById('medicationModal').style.display = 'block';
        }

        // 薬編集モーダルを開く
        function editMedication(timeperiod, id) {
            const medication = medications[timeperiod].find(m => m.id === id);
            if (!medication) return;

            currentTimeperiod = timeperiod;
            currentEditId = id;
            
            document.getElementById('medicationName').value = medication.name;
            document.getElementById('medicationTiming').value = medication.timing;
            document.getElementById('dosage').value = medication.dosage;
            document.getElementById('medicationType').value = medication.type;
            
            // 時間帯チェックボックスを設定
            document.getElementById('timeMorning').checked = medication.times.includes('morning');
            document.getElementById('timeNoon').checked = medication.times.includes('noon');
            document.getElementById('timeEvening').checked = medication.times.includes('evening');
            
            document.getElementById('medicationModal').style.display = 'block';
        }

        // モーダルを閉じる
        function closeModal() {
            document.getElementById('medicationModal').style.display = 'none';
        }

        // 薬の服用チェック
        function toggleMedication(timeperiod, id) {
            const medication = medications[timeperiod].find(m => m.id === id);
            if (!medication) return;
            
            const today = new Date().toDateString();
            if (!medication.takenDates) medication.takenDates = [];
            
            const takenIndex = medication.takenDates.findIndex(date => date === today);
            
            if (takenIndex > -1) {
                medication.takenDates.splice(takenIndex, 1);
            } else {
                medication.takenDates.push(today);
                // 履歴に追加
                addToHistory(medication, timeperiod);
            }
            
            saveData();
            renderMedications();
        }

        // 履歴に追加
        function addToHistory(medication, timeperiod) {
            const today = new Date().toDateString();
            const timeText = {morning: '朝', noon: '昼', evening: '夜'}[timeperiod];
            
            let historyEntry = medicationHistory.find(h => h.date === today);
            if (!historyEntry) {
                historyEntry = { date: today, medications: [] };
                medicationHistory.unshift(historyEntry);
            }
            
            historyEntry.medications.push({
                name: medication.name,
                type: medication.type,
                dosage: medication.dosage,
                timing: medication.timing,
                time: timeText,
                timestamp: new Date().toLocaleTimeString('ja-JP', {hour: '2-digit', minute: '2-digit'})
            });
            
            // 1ヶ月以上古い履歴を削除
            const oneMonthAgo = new Date();
            oneMonthAgo.setMonth(oneMonthAgo.getMonth() - 1);
            medicationHistory = medicationHistory.filter(h => new Date(h.date) >= oneMonthAgo);
        }

        // 薬を削除
        function deleteMedication(timeperiod, id) {
            if (confirm('この薬を削除しますか？')) {
                medications[timeperiod] = medications[timeperiod].filter(m => m.id !== id);
                saveData();
                renderMedications();
            }
        }

        // 最近の服薬履歴を取得
        function getRecentHistory(medicationId) {
            const recentDates = [];
            const today = new Date();
            
            // 過去7日間をチェック
            for (let i = 0; i < 7; i++) {
                const checkDate = new Date(today);
                checkDate.setDate(today.getDate() - i);
                const dateStr = checkDate.toDateString();
                
                // 全ての時間帯から該当する薬の服薬記録を探す
                let taken = false;
                ['morning', 'noon', 'evening'].forEach(timeperiod => {
                    const medication = medications[timeperiod].find(m => m.id === medicationId);
                    if (medication && medication.takenDates && medication.takenDates.includes(dateStr)) {
                        taken = true;
                    }
                });
                
                if (taken) {
                    const month = checkDate.getMonth() + 1;
                    const day = checkDate.getDate();
                    recentDates.push(`${month}/${day}`);
                }
            }
            
            return recentDates.reverse().slice(0, 5); // 最新5件
        }

        // フォーム送信
        document.getElementById('medicationForm').addEventListener('submit', function(e) {
            e.preventDefault();
            
            const name = document.getElementById('medicationName').value;
            const timing = document.getElementById('medicationTiming').value;
            const dosage = document.getElementById('dosage').value;
            const type = document.getElementById('medicationType').value;
            
            const times = [];
            if (document.getElementById('timeMorning').checked) times.push('morning');
            if (document.getElementById('timeNoon').checked) times.push('noon');
            if (document.getElementById('timeEvening').checked) times.push('evening');
            
            const medicationData = {
                id: currentEditId || Date.now(),
                name: name,
                timing: timing,
                dosage: dosage,
                type: type,
                times: times,
                takenDates: []
            };
            
            if (currentEditId) {
                // 編集の場合、全ての時間帯から削除して再追加
                ['morning', 'noon', 'evening'].forEach(time => {
                    const existingIndex = medications[time].findIndex(m => m.id === currentEditId);
                    if (existingIndex > -1) {
					// 既存の服薬記録を保持
                        medicationData.takenDates = medications[time][existingIndex].takenDates || [];
                        medications[time] = medications[time].filter(m => m.id !== currentEditId);
                    }
                });
            }
            
            // 選択された時間帯に追加
            times.forEach(time => {
                const existingMed = medications[time].find(m => m.id === medicationData.id);
                if (!existingMed) {
                    medications[time].push({...medicationData});
                }
            });
            
            saveData();
            renderMedications();
            closeModal();
        });

        // 薬一覧をレンダリング
        function renderMedications() {
            ['morning', 'noon', 'evening'].forEach(timeperiod => {
                const container = document.getElementById(timeperiod + '-medications');
                container.innerHTML = '';
                
                medications[timeperiod].forEach(medication => {
                    const today = new Date().toDateString();
                    const isTaken = medication.takenDates && medication.takenDates.includes(today);
                    const recentHistory = getRecentHistory(medication.id);
                    
                    const medicationDiv = document.createElement('div');
                    medicationDiv.className = 'medication-card';
                    medicationDiv.innerHTML = `
                        <div class="medication-header">
                            <div>
                                <div class="medication-name">${medication.name}</div>
                                <div class="medication-details">
                                    <span class="detail-tag timing-tag">${medication.timing}</span>
                                    <span class="detail-tag dosage-tag">${medication.dosage}</span>
                                </div>
                                ${recentHistory.length > 0 ? `
                                <div class="recent-history">
                                    <strong>最近の服薬履歴:</strong> ${recentHistory.join(', ')}
                                </div>
                                ` : ''}
                            </div>
                            <div class="medication-actions">
                                <div class="status-indicator">
                                    <span>${isTaken ? '服薬済み' : '未服薬'}</span>
                                    <button class="check-btn ${isTaken ? 'taken' : ''}" 
                                            onclick="toggleMedication('${timeperiod}', ${medication.id})">
                                        ${isTaken ? '✓' : ''}
                                    </button>
                                </div>
                                <button class="edit-btn" onclick="editMedication('${timeperiod}', ${medication.id})" title="編集">
                                    ✏️
                                </button>
                            </div>
                        </div>
                    `;
                    container.appendChild(medicationDiv);
                });
            });
        }

        // 履歴をレンダリング
        function renderHistory() {
            const container = document.getElementById('history-list');
            container.innerHTML = '';
            
            if (medicationHistory.length === 0) {
                container.innerHTML = '<p style="text-align: center; color: #999; margin-top: 40px;">まだ服薬履歴がありません</p>';
                return;
            }
            
            medicationHistory.forEach(entry => {
                const historyDiv = document.createElement('div');
                historyDiv.className = 'history-item';
                
                const date = new Date(entry.date);
                const dateStr = `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()} (${['日', '月', '火', '水', '木', '金', '土'][date.getDay()]})`;
                
                let medicationsText = entry.medications.map(med => 
                    `${med.time} - ${med.name} (${med.timing}, ${med.dosage}) [${med.timestamp}]`
                ).join('<br>');
                
                historyDiv.innerHTML = `
                    <div class="history-date">${dateStr}</div>
                    <div class="history-medications">${medicationsText}</div>
                `;
                container.appendChild(historyDiv);
            });
        }

        // データ保存
        function saveData() {
            // メモリ内に保存（実際の実装ではlocalStorageなど使用）
        }

        // データ読み込み
        function loadData() {
            // サンプルデータ
            medications = {
                morning: [
                    {
                        id: 1,
                        name: 'ビタミンB複合剤',
                        timing: '食後',
                        dosage: '1錠',
                        type: '錠剤',
                        times: ['morning'],
                        takenDates: ['Fri Jul 18 2025', 'Thu Jul 17 2025', 'Wed Jul 16 2025']
                    },
                    {
                        id: 2,
                        name: 'オメプラゾール',
                        timing: '食前',
                        dosage: '20mg',
                        type: '錠剤',
                        times: ['morning'],
                        takenDates: ['Fri Jul 18 2025', 'Thu Jul 17 2025']
                    }
                ],
                noon: [],
                evening: []
            };
        }

        // モーダルの外側クリックで閉じる
        window.onclick = function(event) {
            const modal = document.getElementById('medicationModal');
            if (event.target === modal) {
                closeModal();
            }
        }
        function renderSchedules() {
            const container = document.getElementById('scheduleContainer');
            
            if (schedules.length === 0) {
                container.innerHTML = '<div class="empty-state">まだ予定がありません</div>';
                return;
            }

            schedules.sort((a, b) => a.time.localeCompare(b.time));

            container.innerHTML = schedules.map((schedule, index) => `
                <div class="schedule-item">
                    <div class="schedule-time">${schedule.time}</div>
                    <div class="schedule-content">${schedule.content}</div>
                    <div class="schedule-actions">
                        <button class="btn-small btn-edit" onclick="editSchedule(${index})" title="編集">✏️</button>
                        <button class="btn-small btn-delete" onclick="deleteSchedule(${index})" title="削除">🗑️</button>
                    </div>
                    <div class="edit-form" id="editForm${index}">
                        <input type="time" id="editTime${index}" value="${schedule.time}">
                        <input type="text" id="editContent${index}" value="${schedule.content}">
                        <button class="btn-small" onclick="saveEdit(${index})">保存</button>
                        <button class="btn-small" onclick="cancelEdit(${index})">キャンセル</button>
                    </div>
                </div>
            `).join('');
        }

        function openModal() {
            document.getElementById('modalOverlay').style.display = 'flex';
            document.getElementById('timeInput').focus();
        }

        function closeModal(event) {
            if (event && event.target !== event.currentTarget) return;
            document.getElementById('modalOverlay').style.display = 'none';
            document.getElementById('timeInput').value = '';
            document.getElementById('contentInput').value = '';
        }

        function addSchedule() {
            const timeInput = document.getElementById('timeInput');
            const contentInput = document.getElementById('contentInput');
            
            if (!timeInput.value || !contentInput.value.trim()) {
                alert('時刻と内容を入力してください');
                return;
            }

            schedules.push({
                time: timeInput.value,
                content: contentInput.value.trim()
            });

            renderSchedules();
            closeModal();
        }

        function editSchedule(index) {
            const editForm = document.getElementById(`editForm${index}`);
            editForm.style.display = editForm.style.display === 'block' ? 'none' : 'block';
        }

        function saveEdit(index) {
            const newTime = document.getElementById(`editTime${index}`).value;
            const newContent = document.getElementById(`editContent${index}`).value.trim();
            
            if (!newTime || !newContent) {
                alert('時刻と内容を入力してください');
                return;
            }

            schedules[index] = {
                time: newTime,
                content: newContent
            };

            renderSchedules();
        }

        function cancelEdit(index) {
            document.getElementById(`editForm${index}`).style.display = 'none';
        }

        function deleteSchedule(index) {
            if (confirm('この予定を削除しますか？')) {
                schedules.splice(index, 1);
                renderSchedules();
            }
        }

        // エンターキーで追加
        document.getElementById('contentInput').addEventListener('keypress', function(e) {
            if (e.key === 'Enter') {
                addSchedule();
            }
        });

        // ESCキーでモーダルを閉じる
        document.addEventListener('keydown', function(e) {
            if (e.key === 'Escape') {
                closeModal();
            }
        });

        // 初期表示
        renderSchedules();
    </script>
</body>
</html>