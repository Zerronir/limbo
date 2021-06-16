package com.limbo.service;

import com.limbo.entities.Compra;
import com.limbo.entities.DetallCompra;

public interface CompraService {
    Compra save(Compra compra) throws Exception;
    DetallCompra saveDetall(DetallCompra detallCompra) throws Exception;
}
