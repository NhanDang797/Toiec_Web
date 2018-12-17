package dao;

import java.io.Serializable;
import java.util.List;

    /*
    *   ID : kieu du lieu ID cua moi bang
    *   T  : ten Entity
    */
public interface GenericDao <ID extends Serializable, T> {
    List<T> findAll(); // hien thi tat ca
    T update(T  entity); // hàm update (Truyền vào 1 Object  entity);
    void save(T entity) ; // hàm save
    /* Tìm kiếm theo ID của đối tượng */
    T findById(ID id);// hàm findByID (kiểu , giá trị)
    /*   Tìm kiếm theo thuộc tính của đối tượng
         kiểu trả về là 1 mảng OBject[] : 0: size của mảng , 1: list Object
         4 tham số: 1: tên của trường muốn tìm
                    2: giá trị của trường , nó có thể là nhiều trường nên cho kiểu là object
                    3: trường muốn sắp xếp ;
                    4: chiều sắp xếp
    */
    Object[] findByProperty(String property,Object value , String sortExpression , String sortDirection);
    /*delete*/
    Integer delete(List<ID> ids);
}
