package es.jaime.pruebatecnica.product.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "product", schema = "mydb")
public final class Product {

    @Id
    private long id;
    @Column
    private long sequence;

}
