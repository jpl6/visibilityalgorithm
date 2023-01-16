package es.jaime.pruebatecnica.product.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "stock", schema = "mydb")
public final class Stock {

    @Id
    @Column(name = "size_id")
    private long sizeId;
    @Column
    private long quantity;

}
