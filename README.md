# 📄 Project Duo - Document Service System

ระบบจำลองการส่งคำขอลงนามและแก้ไขเอกสารระหว่าง 2 ฝั่ง พัฒนาด้วย Spring Boot และ RESTful API

## 🎯 ภาพรวมระบบ

โปรเจกต์นี้ประกอบด้วย 2 บริการหลัก:

- **🅰️ Document Service (ClientA)**: ระบบฝั่งเซิร์ฟเวอร์ที่รับผิดชอบจัดการเอกสาร ลงนาม และแก้ไขเอกสาร
- **🅱️ Client Service (ClientB)**: ระบบฝั่งไคลเอนต์ที่ส่งคำขอไปยัง Document Service

### ⚡ คุณสมบัติหลัก

- ✅ ส่งคำขอลงนามเอกสาร
- ✅ ส่งคำขอแก้ไขเอกสาร
- ✅ ตรวจสอบสถานะคำขอ
- ✅ จัดเก็บข้อมูลด้วย H2 Database
- ✅ RESTful API สำหรับการสื่อสารระหว่างระบบ

---

## 📁 โครงสร้างโปรเจกต์

```
Project-Duo---Document-Service-System/
├── ClientA/                                      # Document Service (ฝั่ง A)
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/documentservice/
│   │       │   ├── controller/
│   │       │   │   └── ServiceController.java
│   │       │   ├── dto/
│   │       │   │   ├── SignDocumentDto.java
│   │       │   │   ├── EditRequestDto.java
│   │       │   │   └── ServiceResponseDto.java
│   │       │   ├── service/
│   │       │   │   ├── SignatureService.java
│   │       │   │   └── EditService.java
│   │       │   ├── model/
│   │       │   │   ├── Document.java
│   │       │   │   ├── ServiceRequest.java
│   │       │   │   ├── ServiceStatus.java
│   │       │   │   ├── ServiceType.java
│   │       │   │   └── User.java
│   │       │   └── repository/
│   │       │       ├── DocumentRepository.java
│   │       │       └── ServiceRequestRepository.java
│   │       └── resources/
│   │           ├── application.properties
│   │           └── data.sql
│   └── pom.xml
│
├── ClientB/                                      # Client Service (ฝั่ง B)
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/clientservice/
│   │       │   ├── controller/
│   │       │   ├── service/
│   │       │   └── dto/
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml
│
├── postman/                                      # Postman Collections
│   ├── ClientA-API.postman_collection.json
│   └── ClientB-API.postman_collection.json
│
├── .gitignore
└── README.md
```

---

## 🛠️ เทคโนโลยีที่ใช้

- **Java**: JDK 17 หรือ 21
- **Spring Boot**: 3.x
- **Spring Data JPA**: สำหรับจัดการฐานข้อมูล
- **H2 Database**: ฐานข้อมูลในหน่วยความจำสำหรับการทดสอบ
- **Maven**: สำหรับจัดการ dependencies
- **RESTful API**: สำหรับการสื่อสารระหว่างระบบ

---

## ⚙️ การติดตั้งและเริ่มใช้งาน

### ✅ ความต้องการของระบบ

ตรวจสอบให้แน่ใจว่าคุณได้ติดตั้งโปรแกรมต่อไปนี้แล้ว:

- **Java JDK 17 หรือ 21**
  ```bash
  java -version
  ```
- **Apache Maven 3.6+**
  ```bash
  mvn -version
  ```
- **Postman** (สำหรับทดสอบ API)

---

## 🚀 การรันระบบ

### 🅰️ ขั้นตอนที่ 1: รัน Document Service (ClientA)

1. เปิด Terminal และไปที่โฟลเดอร์ ClientA
   ```bash
   cd ClientA
   ```

2. ติดตั้ง dependencies
   ```bash
   mvn clean install
   ```

3. รันระบบ
   ```bash
   mvn spring-boot:run
   ```

4. ตรวจสอบว่าระบบทำงาน
   ```
   ✅ Server รันที่: http://localhost:8080
   ```

**💡 เปลี่ยนพอร์ต:** แก้ไขไฟล์ `src/main/resources/application.properties`
```properties
server.port=8080
```

---

### 🅱️ ขั้นตอนที่ 2: รัน Client Service (ClientB)

1. **เปิด Terminal ใหม่** และไปที่โฟลเดอร์ ClientB
   ```bash
   cd ClientB
   ```

2. ติดตั้ง dependencies
   ```bash
   mvn clean install
   ```

3. รันระบบ
   ```bash
   mvn spring-boot:run
   ```

4. ตรวจสอบว่าระบบทำงาน
   ```
   ✅ Server รันที่: http://localhost:8081
   ```

**💡 เปลี่ยนพอร์ต:** แก้ไขไฟล์ `src/main/resources/application.properties`
```properties
server.port=8081
clienta.url=http://localhost:8080  # URL ของ ClientA
```

---

## 📬 การทดสอบ API ด้วย Postman

### 1️⃣ Import Postman Collection

1. เปิด **Postman**
2. คลิก **Import** (มุมซ้ายบน)
3. เลือกไฟล์ทั้ง 2 ไฟล์จากโฟลเดอร์ `postman/`:
   - `ClientA-API.postman_collection.json`
   - `ClientB-API.postman_collection.json`

### 2️⃣ API Endpoints

#### 🅰️ ClientA (Document Service) - Port 8080

| Method | Endpoint | คำอธิบาย |
|--------|----------|----------|
| `POST` | `/api/services/sign` | รับคำขอลงนามเอกสาร |
| `POST` | `/api/services/edit` | รับคำขอแก้ไขเอกสาร |
| `GET` | `/api/documents/{id}` | ดูข้อมูลเอกสาร |
| `GET` | `/api/services/requests` | ดูรายการคำขอทั้งหมด |
| `GET` | `/api/services/requests/{id}` | ดูรายละเอียดคำขอ |

#### 🅱️ ClientB (Client Service) - Port 8081

| Method | Endpoint | คำอธิบาย |
|--------|----------|----------|
| `POST` | `/api/send-sign-request` | ส่งคำขอลงนามไปยัง ClientA |
| `POST` | `/api/send-edit-request` | ส่งคำขอแก้ไขไปยัง ClientA |

### 3️⃣ ตัวอย่างการใช้งาน

#### ส่งคำขอลงนามจาก ClientB

**Request:**
```http
POST http://localhost:8081/api/send-sign-request
Content-Type: application/json

{
  "documentId": 1,
  "requesterId": 2,
  "reason": "ขออนุมัติลงนามเอกสารสัญญา"
}
```

**Response:**
```json
{
  "requestId": 1,
  "status": "REQUESTED",
  "message": "ส่งคำขอลงนามสำเร็จ",
  "timestamp": "2025-02-15T10:30:00"
}
```

---

## 🗄️ การตรวจสอบฐานข้อมูล H2

ClientA ใช้ H2 Database ในหน่วยความจำสำหรับจัดเก็บข้อมูล

### เข้าถึง H2 Console:

1. เปิดเบราว์เซอร์ไปที่:
   ```
   http://localhost:8080/h2-console
   ```

2. กรอกข้อมูลการเชื่อมต่อ:
   ```
   JDBC URL: jdbc:h2:mem:testdb
   Username: sa
   Password: (เว้นว่าง)
   ```

3. คลิก **Connect**

### ตารางที่สำคัญ:

- `USERS`: ข้อมูลผู้ใช้
- `DOCUMENTS`: ข้อมูลเอกสาร
- `SERVICE_REQUESTS`: ข้อมูลคำขอบริการ

---

## 🧪 การทดสอบระบบ

### Scenario 1: ส่งคำขอลงนาม

1. รัน ClientA และ ClientB
2. ใช้ Postman ส่ง request ไปที่ ClientB:
   ```
   POST http://localhost:8081/api/send-sign-request
   ```
3. ClientB จะส่งคำขอไปยัง ClientA
4. ตรวจสอบใน H2 Console ว่ามีข้อมูลคำขอถูกบันทึก

### Scenario 2: แก้ไขเอกสาร

1. ใช้ Postman ส่ง request:
   ```
   POST http://localhost:8081/api/send-edit-request
   ```
2. ตรวจสอบสถานะคำขอผ่าน:
   ```
   GET http://localhost:8080/api/services/requests/1
   ```

---

## 🛠️ Troubleshooting

### ปัญหาที่พบบ่อยและวิธีแก้ไข

| ❌ ปัญหา | 🔍 สาเหตุ | ✅ วิธีแก้ |
|---------|----------|----------|
| `release version 21 not supported` | Java version ไม่ตรงกับที่กำหนดใน pom.xml | 1. ติดตั้ง Java 17/21<br>2. หรือแก้ `pom.xml`:<br>`<java.version>17</java.version>` |
| `No plugin found for prefix 'spring-boot'` | รันคำสั่งนอกโฟลเดอร์ที่มี pom.xml | ใช้ `cd` ไปยังโฟลเดอร์ ClientA หรือ ClientB |
| `Connection refused` | ClientA ยังไม่ได้รัน | รัน ClientA ก่อน จากนั้นค่อยรัน ClientB |
| `Port already in use` | Port ถูกใช้งานอยู่ | 1. ปิดโปรแกรมที่ใช้ port นั้น<br>2. หรือเปลี่ยน port ใน application.properties |
| `Failed to connect to ClientA` | URL ของ ClientA ผิด | ตรวจสอบ `clienta.url` ใน application.properties ของ ClientB |

### เช็ค Port ที่ใช้งานอยู่:

**Windows:**
```bash
netstat -ano | findstr :8080
```

**Mac/Linux:**
```bash
lsof -i :8080
```

---

## 📊 Data Model

### User
```java
- id: Long
- username: String
- email: String
- role: String
```

### Document
```java
- id: Long
- title: String
- content: String
- ownerId: Long
- status: String
- createdDate: Date
```

### ServiceRequest
```java
- id: Long
- documentId: Long
- requesterId: Long
- serviceType: ServiceType (SIGNATURE, EDIT, ACCESS)
- status: ServiceStatus (REQUESTED, APPROVED, REJECTED)
- reason: String
- requestDate: Date
```

---

## 🔐 Security Considerations

⚠️ **หมายเหตุ:** โปรเจกต์นี้เป็นเพียงการสาธิตเท่านั้น ไม่ได้มีการใช้ระบบรักษาความปลอดภัยที่เหมาะสมสำหรับ production

สำหรับการใช้งานจริง ควรเพิ่ม:
- 🔒 Spring Security สำหรับ Authentication/Authorization
- 🔑 JWT Token สำหรับการยืนยันตัวตน
- 🛡️ HTTPS สำหรับการสื่อสารที่ปลอดภัย
- 📝 Logging และ Monitoring
- ✅ Input Validation

---

## 📈 การพัฒนาต่อ (Future Improvements)

- [ ] เพิ่มระบบ Authentication/Authorization
- [ ] รองรับการอัปโหลดไฟล์เอกสารจริง
- [ ] Notification system เมื่อมีคำขอใหม่
- [ ] Dashboard สำหรับแสดงสถิติ
- [ ] Unit Tests และ Integration Tests
- [ ] Docker containerization
- [ ] API Documentation ด้วย Swagger/OpenAPI

---

## 👥 ทีมพัฒนา

| รหัสนักศึกษา | ชื่อ-นามสกุล | บทบาท |
|-------------|-------------|--------|
| 6509650369 | ณรีพัฒน์ รุ่งรำพรรณ | Developer |
| 6509650427 | ทานตะวัน จิตสาร | Developer |

---

## 📝 License

This project is for educational purposes only.

---

## 📞 ติดต่อ

หากมีคำถามหรือพบปัญหา:
- 📧 Email: [tantawanjttsan@gmail.com]
- 🐛 Issues: [GitHub Issues](https://github.com/Thantawan6509650427/Project-Duo---Document-Service-System/issues)

---

## 🙏 Acknowledgments

- Thammasat University and 367 Web Service Subject
- Spring Boot Documentation
- Stack Overflow Community

---

**⭐ หากโปรเจกต์นี้มีประโยชน์ กรุณากด Star ใน GitHub**