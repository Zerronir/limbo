package com.limbo.DAO;

import com.limbo.entities.Compra;
import com.limbo.entities.DetallCompra;

public interface CompraDAO{
    Compra save(Compra compra) throws Exception;
    DetallCompra saveDetall(DetallCompra detallCompra) throws Exception;
}
