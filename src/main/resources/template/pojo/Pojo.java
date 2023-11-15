package ${package_pojo};

import com.xqxls.common.entity.BaseEntity;
<#if swagger==true>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
<#list typeSet as set>
import ${set};
</#list>

/**
 * ${tableComment} Entity
 * ${TableName}
 *
 * @Author: ${Table}构建
 * @Description: ${Table}构建
 * @Date ${time}
 */
@Data
@EqualsAndHashCode(callSuper = true)
<#if swagger==true>
@ApiModel(description = "${tableComment}", value = "${tableComment}")
</#if>
@Table(name = "${TableName}")
public class ${Table} extends BaseEntity {
<#list models as model>
<#if model.column != 'id'
		&&  model.column != 'tenement_id'
		&&  model.column != 'create_time'
		&&  model.column != 'update_time'
		&&  model.column != 'create_id'
		&&  model.column != 'update_id'
		&&  model.column != 'create_name'
		&&  model.column != 'update_name'
		&&  model.column != 'is_del'
		&&  model.column != 'is_enable'
		&&  model.column != 'version'
		>

	/**
	 * ${model.desc!""}
	 */
	<#if model.id==true>
	@Id
	</#if>
	<#if model.nullAble=='NO'>
	@NotNull(message = "不能为空")
	</#if>
	<#if model.identity=='YES'>
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	</#if>
	@Column(name = "${model.column}")
	<#if swagger==true>
	@ApiModelProperty(value = "${model.desc!""}"<#if  model.nullAble =='NO'>, required = true</#if>)
	</#if>
	private ${model.simpleType} ${model.name};

</#if>
</#list>

}
