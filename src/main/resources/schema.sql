-- Tabla estados
CREATE TABLE estados (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nom_estados VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    update_at DATETIME
);

-- Tabla tipos
CREATE TABLE tipos (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nom_tipo VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    update_at DATETIME
);

-- Tabla servicios
CREATE TABLE servicios (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nom_servicio VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    update_at DATETIME
);

-- Tabla tribunales
CREATE TABLE tribunales (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nom_tribunales VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    update_at DATETIME
);

-- Tabla escritos
-- Tabla escritos
CREATE TABLE escritos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nro_escritos INT NOT NULL,
    tipo_id INT NOT NULL,
    servicio_id INT NOT NULL,
    jurisdiccion INT NOT NULL,
    tribunal_id INT NOT NULL,
    asunto VARCHAR(255) NOT NULL,
    fec_ingreso DATETIME NOT NULL,
    nro_causa INT NOT NULL,
    observacion VARCHAR(255) NOT NULL,
    estado_id INT NOT NULL,
    recepcion ENUM('PENDIENTE', 'RECEPCIONADO', 'SIN_CAUSA') NOT NULL,
    created_at DATETIME,
    update_at DATETIME
);


-- Índice para la columna asunto en la tabla escritos
CREATE INDEX escritos_asunto_IDX ON escritos (asunto);

-- Definición de restricciones de clave foránea
ALTER TABLE escritos ADD CONSTRAINT fk_estado FOREIGN KEY (estado_id) REFERENCES estados(id);
ALTER TABLE escritos ADD CONSTRAINT fk_tipo FOREIGN KEY (tipo_id) REFERENCES tipos(id);
ALTER TABLE escritos ADD CONSTRAINT fk_servicio FOREIGN KEY (servicio_id) REFERENCES servicios(id);
ALTER TABLE escritos ADD CONSTRAINT fk_tribunal FOREIGN KEY (tribunal_id) REFERENCES tribunales(id);
