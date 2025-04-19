Dưới đây là nội dung README.md đã được sửa chuẩn định dạng Markdown, bạn chỉ cần copy nguyên đoạn này và dán vào file README.md của bạn:

# 🐳 Microservices Project

## 🚀 Khởi chạy hệ thống

````bash
docker-compose up -d



⸻

🌐 API Gateway (Port 8080)

API Gateway định tuyến các request đến các service tương ứng:

Route Prefix	Service Tương Ứng
/service1/**	Service1 - Product Service
/service2/**	Service2 - Order Service



⸻

📦 Service1 - Product Service (Port 8081)

Base path: /products

📘 Endpoints
	•	GET /products
➤ Lấy tất cả sản phẩm
Response: List of Product objects
	•	GET /products/{id}
➤ Lấy sản phẩm theo ID
Response: Product object
	•	POST /products
➤ Tạo sản phẩm mới
Request body: Product object
Response: Created Product object
	•	PUT /products/{id}
➤ Cập nhật sản phẩm
Request body: Product object
Response: Updated Product object
	•	DELETE /products/{id}
➤ Xóa sản phẩm
Response: No content (204)
	•	GET /products/{id}/order-info
➤ Lấy thông tin đơn hàng của sản phẩm (gọi sang Service2)
Response: String (Product info + Order info)

⸻

📦 Service2 - Order Service (Port 8082)

Base path: /orders

📘 Endpoints
	•	GET /orders
➤ Lấy tất cả đơn hàng
Response: List of Order objects
	•	GET /orders/{id}
➤ Lấy đơn hàng theo ID
Response: Order object
	•	GET /orders/by-product/{productId}
➤ Lấy danh sách đơn hàng theo Product ID
Response: List of Order objects
	•	GET /orders/info/{productId}
➤ Lấy thông tin tổng hợp đơn hàng theo Product ID
Response: String (summary info)
	•	POST /orders
➤ Tạo đơn hàng mới
Request body: Order object
Response: Created Order object
	•	PUT /orders/{id}
➤ Cập nhật đơn hàng
Request body: Order object
Response: Updated Order object
	•	DELETE /orders/{id}
➤ Xóa đơn hàng
Response: No content (204)
	•	GET /orders/{id}/product-info
➤ Lấy thông tin sản phẩm của đơn hàng (gọi sang Service1)
Response: String (Order info + Product info)

⸻

🧪 Ví dụ gọi API qua API Gateway

🔹 Service 1: Product Service
	•	Lấy tất cả sản phẩm:
http://localhost:8080/service1/products
	•	Lấy chi tiết sản phẩm:
http://localhost:8080/service1/products/1
	•	Lấy thông tin đơn hàng của sản phẩm:
http://localhost:8080/service1/products/1/order-info

🔹 Service 2: Order Service
	•	Lấy thông tin sản phẩm của đơn hàng:
http://localhost:8080/service2/orders/1/product-info

---

📌 **Lưu ý:** Đừng bỏ sót dấu ``` ở phần bắt đầu và kết thúc code block. Bạn chỉ cần dán nguyên đoạn trên vào file `README.md`, GitHub sẽ tự hiển thị đúng định dạng.

Nếu muốn, mình có thể giúp bạn thêm phần mô tả cấu trúc JSON mẫu cho `Product` và `Order`. Cần không?
````
