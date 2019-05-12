INSERT INTO localizacion (id_localizacion, nombre, ubicacion) VALUES (1, 'Colombia', NULL);
INSERT INTO localizacion (id_localizacion, nombre, ubicacion) VALUES (2, 'Ecuador', NULL);
INSERT INTO localizacion (id_localizacion, nombre, ubicacion) VALUES (3, 'Peru', NULL);
INSERT INTO localizacion (id_localizacion, nombre, ubicacion) VALUES (4, 'Argentina', NULL);
INSERT INTO localizacion (id_localizacion, nombre, ubicacion) VALUES (101, 'Bogota', 1);
INSERT INTO localizacion (id_localizacion, nombre, ubicacion) VALUES (102, 'Cartagena', 1);
INSERT INTO localizacion (id_localizacion, nombre, ubicacion) VALUES (103, 'Medellin', 1);
INSERT INTO localizacion (id_localizacion, nombre, ubicacion) VALUES (203, 'Quito', 2);

INSERT INTO area (id_area, nombre, id_localizacion) VALUES (1, 'Contabilidad', 101);
INSERT INTO area (id_area, nombre, id_localizacion) VALUES (2, 'Recursos humanos', 102);
INSERT INTO area (id_area, nombre, id_localizacion) VALUES (3, 'IT', 203);
INSERT INTO area (id_area, nombre, id_localizacion) VALUES (4, 'Gerencia', 103);

INSERT INTO persona (id_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, cargo) VALUES (1025487896, 'José', NULL, 'Ortíz', 'Pelaez', '1986-01-20', 'Gerente General');
INSERT INTO persona (id_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, cargo) VALUES (1025487847, 'Maria', 'Jesus', 'Martinez', 'Prada', '1986-01-20', 'Director');
INSERT INTO persona (id_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, cargo) VALUES (1026487788, 'Manuel ', 'Ernesto', 'Ochoa', 'López', '1978-10-03', 'Asistente');
INSERT INTO persona (id_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, cargo) VALUES (754866214, 'Dora', NULL, 'Pérez', 'Ortega', '1983-11-14', 'Gerente Ejecutivo');
INSERT INTO persona (id_persona, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, cargo) VALUES (406589745, 'Luis', 'Felipe', 'Andrade', 'Murcia', '1990-08-26', 'Asesor técnico');

INSERT INTO estado (id_estado, nombre, descripcion) VALUES (1, 'Activo', 'Activo fijo activo dento de la empresa');
INSERT INTO estado (id_estado, nombre, descripcion) VALUES (2, 'Dado de baja', 'Activo fijo dado de baja');
INSERT INTO estado (id_estado, nombre, descripcion) VALUES (3, 'En reparacion', 'Activo fijo en reparación');
INSERT INTO estado (id_estado, nombre, descripcion) VALUES (4, 'Disponible', 'Activo fijo disponible en stock');
INSERT INTO estado (id_estado, nombre, descripcion) VALUES (5, 'Asignado', 'Activo fijo asignado a un area o persona');

INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100000, 'Escritorio', 'Mueble', 'Escritorio para empleado', 111236, 20, 80, 160, 120, 540000, '2012-04-14', NULL, 1, 'Cafe', 2, NULL);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100001, 'Organizador', 'Mueble', 'Mueble para documentos', 111237, 15, 25, 98, 40, 256000, '2016-11-30', NULL, 5, 'Blanco', 3, NULL);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100002, 'Teclado', 'Tecnología', 'Teclado para computador', 111238, 5, 2, 30, 15, 89000, '2015-08-11', NULL, 3, 'Negro', 1, NULL);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100003, 'Impresora', 'Tecnología', 'Impresora para área', 111239, 8, 40, 50, 76, 784000, '2017-06-13', NULL, 5, 'Blanca', 4, NULL);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100004, 'Escritorio', 'Mueble', 'Escritorio para empleado', 111240, 20, 80, 160, 125, 600000, '2011-08-22', NULL, 3, 'Gris', 1, NULL);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100005, 'Escritorio', 'Mueble', 'Escritorio para empleado', 111241, 25, 90, 165, 123, 658000, '2017-02-27', NULL, 5, 'Blanco', 1, NULL);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100006, 'Escritorio', 'Mueble', 'Escritorio para empleado', 111242, 23, 80, 178, 115, 746000, '2016-05-19', NULL, 5, 'Blanco', 1, NULL);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100007, 'Computador', 'Tecnología', 'Computador para empleado', 111243, 5, 2, 30, 15, 2300000, '2016-09-17', NULL, 5, 'Negro', NULL, 406589745);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100008, 'Impresora', 'Tecnología', 'Impresora para área', 111244, 8, 40, 50, 76, 784000, '2014-01-21', NULL, 4, 'Blanco', NULL, 754866214);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100009, 'Teclado', 'Tecnología', 'Teclado para computador', 111245, 5, 2, 30, 15, 89000, '2014-07-19', NULL, 2, 'Negro', NULL, 754866214);
INSERT INTO activo (serial, nombre, tipo, descripcion, numero_interno, peso, alto, ancho, largo, valor, fecha_compra, fecha_baja, estado, color, id_area, id_persona) VALUES (100010, 'Computador', 'Tecnología', 'Computador para empleado', 111246, 8, 40, 50, 76, 1865000, '2015-12-3', NULL, 5, 'Blanco', NULL, 1025487847);
