package dao;

import business.ImportExcel;
import dao.impl.InsumoRepositoryImpl;
import rest.model.Insumo;

import java.util.List;

/**
 * Created by Livia on 21/06/2016.
 */
public class Principal {
    public static void main(String[] args) {
        ImportExcel excel = new ImportExcel();
        String fileName = "C:\\Users\\Livia\\Desktop\\database1.xlsx";
        String sourceDatabaseName = "Caio";

        //TODO
//        if (source.has(fileName)) {
//            if(sobrescrever()) {
//                deleteDatabase(sourceDatabaseName);
//            } else {
//                sourceDatabaseName = "novoDatabaseName";
//            }
//        }

        List<Insumo> listInsumo = excel.readExcel(fileName, sourceDatabaseName);
        InsumoRepository insumoRepository = new InsumoRepositoryImpl();

        for (Insumo insumo : listInsumo) {
            insumoRepository.create(insumo);
            System.out.println("criado"+insumo.getCode());
        }
    }
}
