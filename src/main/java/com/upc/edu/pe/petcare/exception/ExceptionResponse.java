package com.upc.edu.pe.petcare.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/*@Data // igual a @Setter @Getter
@NoArgsConstructor
@AllArgsConstructor*/
public class ExceptionResponse {
    /*private String message;
    private String details;
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime date;*/

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime fecha;
    private String mensaje;
    private String detalles;

    public ExceptionResponse() {
    }

    public ExceptionResponse(LocalDateTime fecha, String mensaje, String detalles) {
        super();
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
