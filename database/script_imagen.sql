CREATE DATABASE imagenes;

USE imagenes;

/*Table structure for table `producto` */

DROP TABLE IF EXISTS producto;
CREATE TABLE producto (
  idProducto int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(20) DEFAULT NULL,
  precio double DEFAULT NULL,
  marca varchar(20) DEFAULT NULL,
  foto longblob,
  PRIMARY KEY (idProducto)
);

select * from imagenes.producto;
