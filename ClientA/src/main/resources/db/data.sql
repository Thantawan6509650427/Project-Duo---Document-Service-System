-- Insert sample request logs
INSERT INTO REQUEST_LOG (DOCUMENT_ID, TYPE, DETAIL, REQUESTED_AT) VALUES
(1, 'SIGN', 'Request to sign rental contract', CURRENT_TIMESTAMP),
(2, 'EDIT', 'Request to edit approval letter', CURRENT_TIMESTAMP),
(3, 'SIGN', 'Request to sign annual report', CURRENT_TIMESTAMP);