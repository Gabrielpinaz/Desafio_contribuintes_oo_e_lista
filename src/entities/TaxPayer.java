package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double serviceIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	
	public TaxPayer(Double salaryIncome, Double serviceIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}


	public double getSalaryIncome() {
		return salaryIncome;
	}


	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}


	public double getServiceIncome() {
		return serviceIncome;
	}


	public void setServiceIncome(double serviceIncome) {
		this.serviceIncome = serviceIncome;
	}


	public double getCapitalIncome() {
		return capitalIncome;
	}


	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}


	public double getHealthSpending() {
		return healthSpending;
	}


	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}


	public double getEducationSpending() {
		return educationSpending;
	}


	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		if (salaryIncome / 12 < 3000) {
			return this.salaryIncome / 12;
		}
		else if (salaryIncome / 12 <= 5000) {
			return this.salaryIncome * 0.1;
		}
		else {
			return this.salaryIncome * 0.2;
		}
		
	}	
	
	public double servicesTax() {
		return this.serviceIncome * 0.15;
	}
	
	public double capitalTax() {
		return this.capitalIncome * 0.2;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double maximumDeductible = (salaryTax() + servicesTax() + capitalTax()) * 0.3;
		double deductibleExpense = this.healthSpending + this.educationSpending;
		
		if (maximumDeductible > deductibleExpense) {
			return deductibleExpense;
		}
		else {
			return maximumDeductible;
		}
		
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
}
