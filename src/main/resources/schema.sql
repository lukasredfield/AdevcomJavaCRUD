-- Tabla escritos
CREATE TABLE escritos (
  id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nro_escritos INT NOT NULL,
  tipo_id INT NOT NULL,
  servicio_id INT NOT NULL,
  jurisdiccion INT NOT NULL,
  tribunal_Id INT NOT NULL,
  asunto VARCHAR(255) NOT NULL,
  fec_ingreso DATETIME NOT NULL,
  nro_causa INT NOT NULL,
  observacion VARCHAR(255) NOT NULL,
  estado_Id INT NOT NULL,
  created_at DATETIME NOT NULL,
  update_at DATETIME NOT NULL
);




-- Tabla tipos
CREATE TABLE tipos (
    id INT PRIMARY KEY NOT NULL,
    nom_tipo VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    update_at DATETIME
);

-- Tabla servicio
CREATE TABLE servicio (
    id INT PRIMARY KEY NOT NULL,
    nom_servicio VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    update_at DATETIME
);

-- Tabla tribunales
CREATE TABLE tribunales (
    id INT PRIMARY KEY NOT NULL,
    nom_tribunales VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    update_at DATETIME
);

-- Tabla estados
CREATE TABLE estados (
    id INT PRIMARY KEY NOT NULL,
    nom_estados VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    update_at DATETIME
);


-- Índice para la columna document en la tabla escritos
CREATE INDEX escritos_asunto_IDX ON escritos (asunto);

-- Columna create_at con valor por defecto en la tabla escritos
ALTER TABLE escritos ADD create_at DATETIME DEFAULT CURRENT_TIMESTAMP NULL



