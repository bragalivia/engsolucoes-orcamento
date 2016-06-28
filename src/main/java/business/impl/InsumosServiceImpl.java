package business.impl;

import business.InsumosService;
import dao.InsumosRepository;
import rest.model.Insumo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Livia on 16/06/2016.
 */
public class InsumosServiceImpl implements InsumosService {
    @Autowired
    private InsumosRepository insumosRepository;
    public boolean create(final Insumo insumo) {
        return insumosRepository.create(insumo);
    }

    public Insumo update(final Insumo insumo) {
        return insumosRepository.update(insumo);
    }

    public Insumo read(final String insumoId) {
        return insumosRepository.read(insumoId);
    }

    public boolean delete(final String origem, final int codigo) {
        return insumosRepository.delete(origem, codigo);
    }
}
