package com.german.edsystem.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;

@Entity
@Data
@Table(name = "alumno")
public class Alumno extends Persona{


}
