1.在实体类中需要使用序列的字段上新增注解
```
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_customer")
@SequenceGenerator(name="seq_customer",allocationSize=1,initialValue=1, sequenceName="seq_customer")
	
```
样例：
```
@Entity
@Table(name = "PrpDcustomer")
@IdClass(PrpDcustomerKey.class)
public class PrpDcustomer extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性客户代码/客户代码 */
	@Id
	@Column(name = "customerCode")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_customer")
	@SequenceGenerator(name="seq_customer",allocationSize=1,initialValue=1, sequenceName="seq_customer")
	private Long customerCode ;
	/** 属性客户类型(1个人/2集体)/客户类型(1个人/2集体) */
	private String customerType ;
	...
}
```
# 注意：
- 序列对应的字段不可以是String类型，可以是Long Integer
- 在新农险的代码中除了实体类需要调整，实体类对应的key类字段类型也需要保持一致
- 样例代码在demo中，测试请求为：http://localhost:8888/customer/testSequence