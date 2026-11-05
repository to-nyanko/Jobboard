package jobboard;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class JobForm {

    @NotNull(message = "企業を選択してください")
    private Long companyId;

    @NotBlank(message = "求人タイトルは必須入力です")
    @Size(max = 100, message = "求人タイトルは100文字以内で入力してください")
    private String title;

    @NotBlank(message = "給与は必須入力です")
    private String salary;

    @NotBlank(message = "仕事内容は必須入力です")
    @Size(min = 10, message = "仕事内容は10文字以上で詳しく入力してください")
    private String description;

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}