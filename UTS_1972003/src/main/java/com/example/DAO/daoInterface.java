/**
 * Ilman Nawali 1972003
 */
package com.example.DAO;

import java.util.List;

public interface daoInterface<E> {
    public int addData(E data);
    public int delData(E data);
    public int updateData(E data);

    public List<E> showData();
}
