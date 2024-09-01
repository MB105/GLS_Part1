import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int ID;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "reciever_name")
    private String receiverName;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status")
    private DeliveryStatus deliveryStatus;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @PrePersist
    public void prePersist() {
        lastUpdated = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        lastUpdated = LocalDateTime.now();


    }
}