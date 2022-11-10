package Datos;

import Models.Conexion;
import Models.ProductoVO;
import java.sql.*;
import java.util.ArrayList;


/*Metodo listar*/
public class ProductoDAO extends Conexion {

    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;

    public ArrayList<ProductoVO> Listar_ProductoVO() {
        ArrayList<ProductoVO> list = new ArrayList<ProductoVO>();
        cn = getConexion();
        String sql = "SELECT * FROM producto;";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoVO vo = new ProductoVO();
                vo.setIdproducto(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setPrecio(rs.getDouble(3));
                vo.setMarca(rs.getString(4));
                vo.setFoto(rs.getBytes(5));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
            }
        }
        return list;
    }


    /*Metodo agregar*/
    public void Agregar_ProductoVO(ProductoVO vo) {
        cn = getConexion();
        String sql = "INSERT INTO producto (idProducto, nombre, precio, marca, foto)\n"
                + "VALUES (NULL,?,?,?,?);";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getPrecio());
            ps.setString(3, vo.getMarca());
            ps.setBytes(4, vo.getFoto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("A " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("B " + ex.getMessage());
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
            }
        }
    }


    /*Metodo Modificar*/
    public void Modificar_ProductoVO(ProductoVO vo) {
        cn = getConexion();
        String sql = "UPDATE producto SET nombre = ?, precio = ?, marca = ?, foto = ? WHERE idProducto = ?;";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getPrecio());
            ps.setString(3, vo.getMarca());
            ps.setBytes(4, vo.getFoto());
            ps.setInt(5, vo.getIdproducto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
            }
        }
    }

    public void Modificar_ProductoVO2(ProductoVO vo) {
        cn = getConexion();
        String sql = "UPDATE producto SET nombre = ?, precio = ?, marca = ? WHERE idProducto = ?;";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getPrecio());
            ps.setString(3, vo.getMarca());
            ps.setInt(4, vo.getIdproducto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
            }
        }
    }

    /*Metodo Eliminar*/
    public void Eliminar_ProductoVO(ProductoVO vo) {
        cn = getConexion();
        String sql = "DELETE FROM producto WHERE idProducto = ?;";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, vo.getIdproducto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
            }
        }
    }

}
