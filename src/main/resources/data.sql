INSERT INTO estados (id, nom_estados, activo, created_at, update_at)
VALUES (1, 'Nombre del Estado', true, '2023-10-21 08:00:00', '2023-10-21 08:00:00');

INSERT INTO tribunales (id, nom_tribunales, activo, created_at, update_at)
VALUES (4, 'Nombre del Estado', true, '2023-10-21 08:00:00', '2023-10-21 08:00:00');


INSERT INTO servicios (id, nom_servicio, activo, created_at, update_at)
VALUES (2, 'Nombre del Servicio', true, '2023-10-21 08:00:00', '2023-10-21 08:00:00');


INSERT INTO tipos (id, nom_tipo, activo, created_at, update_at)
VALUES (1, 'Nombre del Tipo', true, '2023-10-21 08:00:00', '2023-10-21 08:00:00');


INSERT INTO escritos (nro_escritos, tipo_id, servicio_id, jurisdiccion, tribunal_Id, asunto, fec_ingreso, nro_causa, observacion, estado_Id, recepcion, created_at, update_at)
VALUES (123, 1, 2, 3, 4, 'Ejemplo de asunto 1', '2023-10-21 08:00:00', 5678, 'Observación para ejemplo 1', 1, 'PENDIENTE', '2023-10-21 08:00:00', '2023-10-21 08:00:00');

