docker-compose up -d

API Gateway (Port 8080)
API Gateway route các request đến các service tương ứng:

/service1/** -> Service1 (Product Service)
/service2/** -> Service2 (Order Service)

Service1 - Product Service (Port 8081)
Base path: /products
GET /products
Lấy tất cả sản phẩm
Response: List of Product objects
GET /products/{id}
Lấy sản phẩm theo ID
Response: Product object
POST /products
Tạo sản phẩm mới
Request body: Product object
Response: Created Product object
PUT /products/{id}
Cập nhật sản phẩm
Request body: Product object
Response: Updated Product object
DELETE /products/{id}
Xóa sản phẩm
Response: No content (204)
GET /products/{id}/order-info
Lấy thông tin đơn hàng của sản phẩm (gọi sang Service2)
Response: String (Product info + Order info)

Service2 - Order Service (Port 8082)
Base path: /orders
GET /orders
Lấy tất cả đơn hàng
Response: List of Order objects
GET /orders/{id}
Lấy đơn hàng theo ID
Response: Order object
GET /orders/by-product/{productId}
Lấy danh sách đơn hàng theo Product ID
Response: List of Order objects
GET /orders/info/{productId}
Lấy thông tin tổng hợp đơn hàng theo Product ID
Response: String (summary info)
POST /orders
Tạo đơn hàng mới
Request body: Order object
Response: Created Order object
PUT /orders/{id}
Cập nhật đơn hàng
Request body: Order object
Response: Updated Order object
DELETE /orders/{id}
Xóa đơn hàng
Response: No content (204)
GET /orders/{id}/product-info
Lấy thông tin sản phẩm của đơn hàng (gọi sang Service1)
Response: String (Order info + Product info)

VD :
Service 1 :
get all product : http://localhost:8080/service1/products

get detail info : http://localhost:8080/service1/products/1/order-info

get Detail product : http://localhost:8080/service1/products/1

Service 2 :
get detail product-info : http://localhost:8080/service2/orders/1/product-info
