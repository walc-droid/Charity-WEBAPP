package pl.coderslab.charity.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Wybierz ilość!")
    @Min(1)
    private Integer quantity;

    @ManyToMany
    @JoinTable(name = "donation_category")
    @NotEmpty(message = "Wybierz kategorię!")
    private List<Category> categories;

    @ManyToOne
    @NotNull(message = "Wybierz instytucję!")
    private Institution institution;

    @NotBlank(message = "Podaj ulice!")
    private String street;
    @NotBlank(message = "Podaj miasto!")
    private String city;
    @NotBlank(message = "Podaj kod pocztowy!")
    private String zipCode;
    @Size(min = 9)
    private String phone;

    @NotNull(message = "Podaj date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull(message = "Podaj godzinę!")
    private LocalTime pickUpTime;
    private String pickUpComment;

    public Long getId() {
        return id;
    }

    public Donation setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Donation setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Donation setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Donation setInstitution(Institution institution) {
        this.institution = institution;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Donation setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Donation setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Donation setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Donation setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public Donation setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
        return this;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public Donation setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
        return this;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public Donation setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
        return this;
    }
}
