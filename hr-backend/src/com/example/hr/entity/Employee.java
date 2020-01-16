package com.example.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.hr.validation.Iban;
import com.example.hr.validation.TcKimlikNo;

@Entity
@Table(name = "employees")
@NamedQueries({
	@NamedQuery(
		name="Employee.findByIdentity",
		query = "select e from Employee e "
			+ "where e.identityNo=:identity" ),
	@NamedQuery(
			name="Employee.findAll",
			query = "select e from Employee e" )
})
@XmlRootElement
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(1)
	private Long id;	
	@Column(name = "identity", unique = true, nullable = false)
	@TcKimlikNo
	private String identityNo;
	@Column(name = "full_name")
	private String fullname;
	@Column(name = "iban")
	@Iban
	private String iban;
	@Column(name = "salary")
	@Min(2400)
	private double salary;
	@Column(name = "birth_year")
	@Max(2000)
	private int birthYear;
	@Lob
	@Column(name = "photo", columnDefinition = "longblob")
	private byte[] photo;
	@Column(name = "full_time")
	private boolean fulltime;
	@Enumerated(EnumType.STRING)
	private Department department;

	public Employee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", identityNo=" + identityNo + ", fullname=" + fullname + ", iban=" + iban
				+ ", salary=" + salary + ", birthYear=" + birthYear + ", fulltime=" + fulltime + ", department="
				+ department + "]";
	}

}
