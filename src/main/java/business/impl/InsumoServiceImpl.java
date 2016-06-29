package business.impl;

import business.InsumoService;
import dao.InsumoRepository;
import org.springframework.stereotype.Component;
import rest.model.Insumo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Livia on 16/06/2016.
 */
@Component
public class InsumoServiceImpl implements InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;
    public boolean create(final Insumo insumo) {
        return insumoRepository.create(insumo);
    }

    public Insumo update(final Insumo insumo) {
        return insumoRepository.update(insumo);
    }

    public Insumo read(final int code) {
        return insumoRepository.read(code);
    }

    public boolean delete(final String source, final int code) {
        return insumoRepository.delete(source, code);
    }
}
