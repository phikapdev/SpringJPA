INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Fernando', 'Carrillo', 'fer.lfcb9@gmail.com', '2022-10-22','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Luis', 'Bedolla', 'luis.lfcb9@gmail.com', '2022-10-20','');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Jennifer', 'Carrillo', 'jenni.lfcb9@gmail.com', '2022-10-22','');

INSERT INTO productos (nombre, precio, create_at) VALUES ('Panasonic Pantalla LDC', 25990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Sony Camara Digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Hawlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Mica Comoda 5 Cajones', 299990, NOW());

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());

INSERT INTO factura_items(cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO factura_items(cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO factura_items(cantidad, factura_id, producto_id) VALUES(1, 1, 5);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', "Alguna nota Importante", 1, NOW());
INSERT INTO factura_items(cantidad, factura_id, producto_id) VALUES(3, 2, 6);

INSERT INTO authorities (user_id, authority) VALUES(1, 'ADMIN');
INSERT INTO authorities (user_id, authority) VALUES(2, 'USER');

INSERT INTO users(username, password, enabled) VALUES('fercar', '$2a$10$mJWMmGCSCoq/GXSTwgMMweh9i6GpB6CGq4BgwBhTkmz4cYFaeLGsW', 1);
INSERT INTO users(username, password, enabled) VALUES('admin', '$2a$10$hyyYMm6I5pwJ2RakO7mxreuvNJAVGKzge37ZYt.QRQxMUV0sGG8yS', 1);