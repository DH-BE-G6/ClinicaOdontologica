package com.digitalhouse.clinicaodontologicag6.repository;

import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DentistaRepository {

    private static Map<Integer, DentistaEntity> dentistaMap = new HashMap<>();

    private static int idDentista = 1;

    public DentistaEntity create(DentistaEntity dentistaEntity) {
        dentistaEntity.setId(idDentista++);
        dentistaMap.put(dentistaEntity.getId(), dentistaEntity);
        return dentistaEntity;
    }

    public DentistaEntity getById(int id) {
        return dentistaMap.get(id);
    }

    public String excluir(int id){
        dentistaMap.remove(id);
        return "Deletado";
    }

    public DentistaEntity modificar(DentistaEntity dentistaEntity){
        dentistaMap.put(dentistaEntity.getId(), dentistaEntity);
        return dentistaEntity;
    }

    public List<DentistaEntity> buscarTodos(){
        List<DentistaEntity> dentistaEntities = new ArrayList<>(dentistaMap.values());
        return dentistaEntities;//
    }

    public int buscarNome(String name) {
        for (DentistaEntity dentistaEntity : dentistaMap.values()) {
            String nomeDentista = dentistaEntity.getNome();
            if (nomeDentista.equalsIgnoreCase(name))
                return dentistaEntity.getId();
        }
        return 0;
    }
}