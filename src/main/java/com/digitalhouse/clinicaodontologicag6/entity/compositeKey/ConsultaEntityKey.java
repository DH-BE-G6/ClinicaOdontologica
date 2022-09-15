package com.digitalhouse.clinicaodontologicag6.entity.compositeKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ConsultaEntityKey implements Serializable {
    @Column(name="paciente_id")
    private int pacienteId;

    @Column(name = "dentista_id")
    private int dentistaId;

    public ConsultaEntityKey(int pacienteId, int dentistaId) {
        this.pacienteId = pacienteId;
        this.dentistaId = dentistaId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(int dentistaId) {
        this.dentistaId = dentistaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsultaEntityKey)) return false;

        ConsultaEntityKey that = (ConsultaEntityKey) o;

        if (pacienteId != that.pacienteId) return false;
        return dentistaId == that.dentistaId;
    }

    @Override
    public int hashCode() {
        int result = pacienteId;
        result = 31 * result + dentistaId;
        return result;
    }
}
