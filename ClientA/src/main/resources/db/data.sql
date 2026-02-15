-- USERS table
INSERT INTO USERS (ID, ACTIVE, CREATED_AT, EMAIL, NAME, UPDATED_AT) VALUES
(1, TRUE, CURRENT_TIMESTAMP, 'usera@example.com', 'User A', CURRENT_TIMESTAMP),
(2, TRUE, CURRENT_TIMESTAMP, 'userb@example.com', 'User B', CURRENT_TIMESTAMP),
(3, TRUE, CURRENT_TIMESTAMP, 'c@example.com', 'User C', CURRENT_TIMESTAMP),
(4, TRUE, CURRENT_TIMESTAMP, 'd@example.com', 'User D', CURRENT_TIMESTAMP);

-- DOCUMENT table
INSERT INTO DOCUMENT (ID, CONTENT, STATUS, TITLE, OWNER_ID, SIGNED_AT, SIGNED_BY) VALUES
(1, 'This is the content of Document 1', 'SIGNED', 'Document 1', 1, '2025-05-01 21:02:11', 1),
(2, 'This is the content of Document 2', 'SIGNED', 'Document 2', 1, '2025-05-01 21:03:01', 1),
(3, 'รายงานฉบับนี้จัดทำขึ้นเพื่อสรุปผลการดำเนินโครงการฝึกอบรม...', 'DRAFT', 'รายงานสรุปผลโครงการฝึกอบรม', 2, NULL, NULL),
(4, 'เรียน ผู้อำนวยการกองพัสดุ...', 'DRAFT', 'หนังสือขออนุมัติโครงการจัดซื้อครุภัณฑ์', 1, NULL, NULL);

-- SERVICE_REQUEST table
INSERT INTO SERVICE_REQUEST (ID, DESCRIPTION, SERVICE_TYPE, STATUS, TIMESTAMP, DOCUMENT_ID, PROVIDER_ID, REQUESTER_ID) VALUES
(1, 'Request for signature on Document 1', 'SIGNATURE', 'APPROVED', '2025-05-01 17:29:12', 1, 1, 2),
(2, 'Request for signature on Document 2', 'SIGNATURE', 'APPROVED', '2025-05-01 17:58:32', 2, 1, 2),
(3, 'Request for editing Document 1', 'EDIT', 'APPROVED', '2025-05-01 17:52:59', 1, 1, 2),
(4, 'Request for signature on Document 2', 'SIGNATURE', 'APPROVED', '2025-05-01 21:02:11', 2, 1, 2),
(5, 'Request for signature on Document 1', 'SIGNATURE', 'APPROVED', '2025-05-01 21:02:59', 1, 1, 2),
(6, 'Request for signature on Document 2', 'SIGNATURE', 'APPROVED', '2025-05-01 21:03:01', 2, 1, 2),
(7, 'Request for editing Document 2', 'EDIT', 'APPROVED', '2025-05-01 21:05:15', 2, 4, 2);