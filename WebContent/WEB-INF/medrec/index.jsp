<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>診療録</title>
<link rel="stylesheet" href="/zuwaigani/css/medrec.css">
<link rel="stylesheet"
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
  integrity="…"
  crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<!-- ヘッダー -->
		<div class="header">
			<div class="header-top">
				<div class="header-top1">
					<div class="entry-block">
						<div class="entry-date">入居日: ${ medrec.user.day }</div>
						<div class="name">${ medrec.user.name } 様</div>
					</div>
					<div class="patient-info">
						<div class="status-block">
							<div class="status">${ medrec.user.section.getName() }</div>
							<div class="birth">${ medrec.user.birthDay }</div>
						</div>
						<div class="room-number">部屋番号 A-201</div>
						<div class="contact-block">
							<div>電話先 ${ medrec.user.number }</div>
							<div>緊急連絡先 1 ${ medrec.user.sos1 }</div>
							<div>緊急連絡先 2 ${ medrec.user.sos2 }</div>
						</div>
					</div>
				</div>
				<div class="level-block" id="showAddlevelModal" onclick="showAddlevelModal()">
					<div class="level-label">${ medrec.level }</div>
					<div class="level-label">介助レベル</div>
				</div>
				<div class="datetime-block">
					<div class="date">2024.12.24</div>
					<div class="time">20:09</div>
				</div>
			</div>
		</div>



		<!-- メインコンテンツ -->
		<div class="main-content-above">
			<!-- 処方薬セクション -->
			<div class="section-medicine">
				<div class="section-title-medicine">処方薬</div>

				<div class="medicine-tabs">
					<button class="tab active" onclick="switchTab('morning')">朝</button>
					<button class="tab" onclick="switchTab('noon')">昼</button>
					<button class="tab" onclick="switchTab('evening')">晩</button>
					<button class="tab" onclick="switchTab('history')">履歴</button>
				</div>

				<div class="medicine-list1">
					<button class="btn add-button-medicine"
						onclick="showAddMedicineModal()">薬を追加</button>
					<div id="morning" class="medicine-list">
					<c:forEach var="drag" items="${ medrec.morningDrag }">
						<div class="medicine-item">
							<div class="medicine-info">
								<div class="medicine-name">${ drag.name }</div>
								<div class="medicine-dose">${ drag.amount }錠/${ drag.timing.getName() }</div>
							</div>
							<div class="medicine-actions">
								<input type="checkbox" class="checkbox"
									onchange="markAsTaken(this, ${ drag.name }, '朝')">
								<button class="btn btn-small btn-danger"
									onclick="removeMedicine(this)">削除</button>
							</div>
						</div>
					</c:forEach>
					</div>

					<div id="noon" class="medicine-list" style="display: none;">
					<c:forEach var="drag" items="${ medrec.noonDrag }">
						<div class="medicine-item">
							<div class="medicine-info">
								<div class="medicine-name">${ drag.name }</div>
								<div class="medicine-dose">${ drag.amount }錠/${ drag.timing.getName() }</div>
							</div>
							<div class="medicine-actions">
								<input type="checkbox" class="checkbox"
									onchange="markAsTaken(this, ${ drag.name }, '昼')">
								<button class="btn btn-small btn-danger"
									onclick="removeMedicine(this)">削除</button>
							</div>
						</div>
					</c:forEach>
					</div>

					<div id="evening" class="medicine-list" style="display: none;">
					<c:forEach var="drag" items="${ medrec.nightDrag }">
						<div class="medicine-item">
							<div class="medicine-info">
								<div class="medicine-name">${ drag.name }</div>
								<div class="medicine-dose">${ drag.amount }錠/${ drag.timing.getName() }</div>
							</div>
							<div class="medicine-actions">
								<input type="checkbox" class="checkbox"
									onchange="markAsTaken(this, ${ drag.name }, '夜')">
								<button class="btn btn-small btn-danger"
									onclick="removeMedicine(this)">削除</button>
							</div>
						</div>
					</c:forEach>
					</div>

					<div id="history" class="medicine-list" style="display: none;">
						<div id="medicineHistory">
							<!-- 服薬履歴がここに表示される -->
						</div>
					</div>
				</div>
			</div>

			<!-- 注意事項セクション -->
			<div class="section-care">
				<div class="section-title-care2">
					<div calss="title-care-title">注意事項</div>
					<button class="btn add-button-care" id="showAddcareModal"
						onclick="showAddcareModal()">追加</button>
				</div>
				<div id="selectedCareList"></div>
			</div>

			<!-- 申し送り事項 -->
			<div class="section-transfer">
				<div class="section-title-care">
					<div class="title-care">申し送り事項</div>
					<button class="btn add-button-care" onclick="openHistoryModal()">履歴</button>
				</div>
				<button class="btn btn-add-new" onclick="openAddModal()">追加</button>
				<!-- 最新の申し送り事項表示 -->
				<div class="handover-list" id="latestHandover">
				<c:choose>
					<c:when test="${ medrec.mangList.size() > 0 }">
						<c:forEach var="mang" items="${ medrec.mangList }">
		                    <div class="handover-item">
		                    <!-- 	<div class="handover-content">${ mang.employee }</div>  -->
		                        <div class="handover-meta">
		                        	${ mang.message }
		                        </div>
		                 	</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="no-handover">申し送り事項がありません</div>
					</c:otherwise>
				</c:choose>
				</div>
			</div>
		</div>

		<div class="main-content-under">
			<!-- 病歴 -->
			<div class="section-medical-history">
				<div class="section-title-schedule">
					病歴
					<button class="btn add-button-schedule" id="showAddhistoryModal"
						onclick="showAddhistoryModal()">追加</button>
				</div>
			</div>

			<!-- スケジュールセクション -->
			<div class="section-schedule">
				<div class="section-title-schedule">
					スケジュール
					<button class="btn add-button-schedule"
						onclick="showAddScheduleModal()">追加</button>
				</div>
				<div class="schedule-list" id="scheduleList">
  
					<c:forEach var="schedule" items="${ medrec.schedules }">
						<div class="schedule-item">
							<div class="schedule-time">${ schedule.startTime }</div>
							<div class="schedule-content">${ schedule.process }</div>
							<div class="schedule-actions">
								<button class="btn btn-small-schedule"
									onclick="editSchedule(this)">編集</button>
								<button class="btn btn-small-schedule btn-danger-schedule"
									onclick="removeSchedule(this)">削除</button>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- アレルギー表示 -->
			<div class="section-allergy">
				<div class="section-title-schedule">
					アレルギー
					<button class="btn add-button-schedule" id="showAddallergyModal"
						onclick="showAddallergyModal()">追加</button>
				</div>
			</div>
			<!-- 身体測定 -->
			<div class="section-measurements">
				<div class="section-title-schedule">
					身体測定
					<button class="btn add-button-schedule"
						id="showAddmeasurementsModal" onclick="showAddmeasurementsModal()">追加</button>
				</div>
				<div class="measurements-list">
					<img src="/zuwaigani/image/sokutei.png" alt="身体測定" width="100" height="100" />
				</div>
			</div>
		</div>
	</div>
	<!-- 薬追加モーダル -->
	<div id="addMedicineModal" class="modal">
		<div class="modal-content">
			<div class="modal-header">薬を追加</div>
			<form id="addMedicineForm">
				<div class="form-group">
					<label class="form-label">薬名</label> <input type="text"
						class="form-input" id="medicineName" required>
				</div>
				<div class="form-group">
					<label class="form-label">用法・用量</label> <input type="text"
						class="form-input" id="medicineDose" required>
				</div>
				<div class="form-group">
					<label class="form-label">服薬タイミング</label> <select
						class="form-select" id="medicineTime" required>
						<option value="morning">朝</option>
						<option value="noon">昼</option>
						<option value="evening">晩</option>
					</select>
				</div>
				<div class="form-group">
					<label class="form-label">服用指示</label> <select class="form-select"
						id="dosing-instructions" required>
						<option value="before-meals">食前</option>
						<option value="after-meal">食後</option>
						<option value="between-meals">食間</option>
						<option value="before-bedtime">就寝前</option>
						<option value="temporary-clothes">頓服</option>
						<option value="fasting">空腹時</option>
					</select>
				</div>
				<div class="modal-actions">
					<button type="button" class="btn"
						onclick="closeModal('addMedicineModal')">キャンセル</button>
					<button type="submit" class="btn">追加</button>
				</div>
			</form>
		</div>
	</div>

	<!-- 新規追加モーダル -->
	<div id="addModal" class="modal-transfer">
		<div class="modal-content-transfer">
			<div class="modal-header-transfer">
				<div class="modal-title-transfer">申し送り事項の追加</div>
				<span class="close-transfer" onclick="closeAddModal()">&times;</span>
			</div>
			<div class="modal-body-transfer">
				<form id="addHandoverForm">
					<div class="form-group-transfer">
						<label class="form-label-transfer" for="handoverContent">申し送り内容</label>
						<textarea class="form-control-transfer" id="handoverContent"
							name="content" placeholder="申し送り事項を入力してください..." required></textarea>
					</div>
					<div class="modal-buttons-transfer">
						<button type="button" class="btn btn-secondary-transfer"
							onclick="closeAddModal()">キャンセル</button>
						<button type="submit" class="btn btn-primary-transfer">追加</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 履歴表示モーダル -->
	<div id="historyModal" class="modal-transfer">
		<div class="modal-content-transfer">
			<div class="modal-header-transfer">
				<div class="modal-title-transfer">申し送り事項履歴</div>
				<span class="close-transfer" onclick="closeHistoryModal()">&times;</span>
			</div>
			<div class="modal-body-transfer">
				<div class="history-list-transfer" id="historyList">
					<div style="text-align: center; color: #ff9766;">読み込み中...</div>
				</div>
			</div>
		</div>
	</div>

	<!-- スケジュール追加/編集モーダル -->
	<div id="addScheduleModal" class="modal">
		<div class="modal-content">
			<div class="modal-header" id="scheduleModalTitle">スケジュール追加</div>
			<form id="addScheduleForm">
				<div class="form-group">
					<label class="form-label">時間</label> <input type="time"
						class="form-input" id="scheduleTime" required>
				</div>
				<div class="form-group">
					<label class="form-label">内容</label> <input type="text"
						class="form-input" id="scheduleContent" required>
				</div>
				<div class="modal-actions">
					<button type="button" class="btn"
						onclick="closeModal('addScheduleModal')">キャンセル</button>
					<button type="submit" class="btn" id="scheduleSubmitBtn">追加</button>
				</div>
			</form>
		</div>
	</div>

	<!-- 病歴追加・編集モーダル -->
	<div id="addhistoryModal" class="modal">
		<div class="modal-content">
			<div class="modal-header" id="scheduleModalTitle">病歴追加</div>
			<form id="addhistoryForm">
				<div class="form-group">
					<label class="form-label">発症年齢</label> <input type="text"
						class="form-input" id="age-of-onset" required>
				</div>
				<div class="form-group">
					<label class="form-label">病名</label> <input type="text"
						class="form-input" id="disease-name" required>
				</div>
				<div class="form-group">
					<label class="form-label">状態</label> <input type="text"
						class="form-input" id="situation" required>
				</div>
				<div class="modal-actions">
					<button type="button" class="btn"
						onclick="closeModal('addhistoryModal')">キャンセル</button>
					<button type="submit" class="btn" id="historySubmitBtn">追加</button>
				</div>
			</form>
		</div>
	</div>

	<!-- アレルギー追加・編集モーダル -->
	<div id="addallergyModal" class="modal">
		<div class="modal-content">
			<div class="modal-header" id="allergyModalTitle">病歴追加</div>
			<form id="addhistoryForm">
				<div class="form-group">
					<label class="form-label">アレルギー名</label> <input type="text"
						class="form-input" id="allergy-name" required>
				</div>
				<div class="form-group">
					<label class="form-label">メモ</label> <input type="text"
						class="form-input" id="allergy-memo" required>
				</div>
				<div class="modal-actions">
					<button type="button" class="btn"
						onclick="closeallergyModal('addallergyModal')">キャンセル</button>
					<button type="submit" class="btn" id="allergySubmitBtn">追加</button>
				</div>
			</form>
		</div>
	</div>

	<!-- 身体測定情報追加・編集モーダル -->
	<div id="addmeasurementsModal" class="modal">
		<div class="modal-content">
			<div class="modal-header" id="measurementsModalTitle">身体測定情報編集</div>
			<form id="addhistoryForm">
				<div class="form-group">
					<label class="form-label">身長</label> <input type="text"
						class="form-input" id="height" required>
				</div>
				<div class="form-group">
					<label class="form-label">体重</label> <input type="text"
						class="form-input" id="body-weight" required>
				</div>
				<div class="form-group">
					<label class="form-label">最高血圧</label> <input type="text"
						class="form-input" id="systolic-blood-pressure" required>
				</div>
				<div class="form-group">
					<label class="form-label">最低血圧</label> <input type="text"
						class="form-input" id="diastolic-blood-pressure" required>
				</div>
				<div class="modal-actions">
					<button type="button" class="btn"
						onclick="closemeasurementsModal('addmeasurementsModal')">キャンセル</button>
					<button type="submit" class="btn" id="measurementsSubmitBtn">追加</button>
				</div>
			</form>
		</div>
	</div>
	<!-- 注意事項追加/編集モーダル -->
	<div id="addcareModal" class="modal">
		<div class="modal-content2" class="modal-content">
			<div class="modal-header" id="careModalTitle">注意事項追加</div>
			<div class="modal-text" id="careModaltext">追加する注意事項を選択し、更新ボタンを押してください。</div>
			<form id="careForm">
				<div class="form-content">
					<div class="modalabel-content">
						<img src="/zuwaigani/image/work.png" alt="歩行介助" width="40" height="40" /> <label
							class="label-text">歩行介助</label> <input type="checkbox"
							name="care" value="歩行介助">
					</div>
					<div class="modalabel-content">
						<img src="/zuwaigani/image/eat.png" alt="食事介助" width="40" height="40" /> <label
							class="label-text">食事介助</label> <input type="checkbox"
							name="care" value="食事介助">
					</div>
					<div class="modalabel-content">
						<img src="/zuwaigani/image/wash.png" alt="入浴介助" width="40" height="40" /> <label
							class="label-text"> 入浴介助</label> <input type="checkbox"
							name="care" value="入浴介助">
					</div>
					<div class="modalabel-content">
						<img src="/zuwaigani/image/bed.png" alt="褥瘡介助" width="40" height="40" /> <label
							class="label-text">褥瘡介助</label> <input type="checkbox"
							name="care" value="褥瘡介助">
					</div>
					<div class="modalabel-content">
						<img src="/zuwaigani/image/drag.png" alt="服薬介助" width="40" height="40" /> <label
							class="label-text">服薬介助</label> <input type="checkbox"
							name="care" value="服薬介助">
					</div>
					<div class="modalabel-content">
						<img src="/zuwaigani/image/toire.png" alt="排泄介助" width="40" height="40" /> <label
							class="label-text">排泄介助</label> <input type="checkbox"
							name="care" value="排泄介助">
					</div>
					<div class="modalabel-content">
						<img src="/zuwaigani/image/car.png" alt="車椅子介助" width="40" height="40" /> <label
							class="label-text">車椅子介助</label> <input type="checkbox"
							name="care" value="車椅子介助">
					</div>
				</div>
				<div class="modal-actions">
					<button type="button" class="btn"
						onclick="closecareModal('addcareModal')">キャンセル</button>
					<button type="submit" class="btn" id="careSubmitBtn">更新</button>
				</div>
			</form>



		</div>
	</div>
	<!-- 介助レベル編集モーダル -->
	<div id="addlevelModal" class="modal">
		<div class="modal-content2" class="modal-content">
			<div class="modal-header" id="levelModalTitle">介助レベル選択</div>
			<div class="modal-text" id="levelModaltext">介助レベルを選択してください。</div>
			<form id="careForm">
				<div class="form-content">
					<div class="modalabel-content" data-level="レベル1">
						<i class="fas fa-exclamation-circle"></i>
						<label class="level-text">レベル１</label>
					</div>
					<div class="modalabel-content" data-level="レベル2">
						<i class="fas fa-exclamation-circle"></i>
						<label class="level-text">レベル２</label>
					</div>
					<div class="modalabel-content" data-level="レベル3">
						<i class="fas fa-exclamation-circle"></i> <label
							class="level-text">レベル３</label>
					</div>
					<div class="modalabel-content" data-level="レベル4">
						<i class="fas fa-exclamation-circle"></i> <label
							class="level-text"> レベル４</label>
					</div>
					<div class="modalabel-content" data-level="レベル5">
						<i class="fas fa-exclamation-circle"></i>
						<label class="level-text">レベル５</label>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script src="/zuwaigani/js/medrec.js" defer></script>
</body>
</html>