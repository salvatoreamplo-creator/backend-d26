package salvoamplo.esercitazione.payloads;

import java.time.LocalDate;

public class PrenotazioneRequest {

    private Long dipendenteId;
    private Long viaggioId;
    private LocalDate dataRichiesta;
    private String note;

    public Long getDipendenteId() {
        return dipendenteId;
    }

    public void setDipendenteId(Long dipendenteId) {
        this.dipendenteId = dipendenteId;
    }

    public Long getViaggioId() {
        return viaggioId;
    }

    public void setViaggioId(Long viaggioId) {
        this.viaggioId = viaggioId;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
