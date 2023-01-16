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
@Table(name = "size", schema = "mydb")
public final class Size {

    @Id
    private long id;
    @Column(name = "product_id")
    private long productId;
    @Column
    private boolean backsoon;
    @Column
    private boolean special;

}
