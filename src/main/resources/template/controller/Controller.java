package ${package_controller};

import ${package_pojo}.${Table};
import ${package_service}.${Table}Service;
import com.github.pagehelper.PageInfo;
import com.xqxls.common.api.CommonResult;
import com.xqxls.common.domain.ArrayBodyParam;
import com.xqxls.common.domain.UserDto;
import com.xqxls.util.SecurityUtil;
<#if swagger == true>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
</#if>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * ${tableComment} Controller
 * ${TableName}
 *
 * @Author: ${Table}构建
 * @Description: ${Table}构建
 * @Date ${time}
 */
@Validated
<#if swagger==true>@Api(tags = "${tableComment}Controller")</#if>
@RestController
@RequestMapping("/${table}")
@CrossOrigin
public class ${Table}Controller {

    @Autowired
    private ${Table}Service ${table}Service;

    /***
     * ${Table}分页条件搜索实现
     *
     * @param ${table}
     * @param page 页码
     * @param size 每页数量
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件分页查询",notes = "分页条件查询${Table}方法详情")
    </#if>
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo<${Table}>> findPage(@RequestBody <#if swagger==true>@ApiParam(name = "${Table}对象", value = "传入JSON数据")</#if> ${Table} ${table},
                                                     <#if swagger==true>@ApiParam(value = "当前页", required = true)</#if> @PathVariable("page")  Integer page,  <#if swagger==true>@ApiParam(required = true)</#if> @PathVariable("size")  Integer size,
                                                     <#if swagger==true>@ApiParam("指定排序字段,如指定更新时间排序,字段传值updateTime.传null表示默认排序")</#if> @RequestParam(value = "orderBy", required = false) String orderBy,
                                                     <#if swagger==true>@ApiParam("是否升序, true:升序, false:降序, 仅orderBy有值时生效")</#if> @RequestParam(value = "acs", required = false) Boolean asc) {
        //调用${Table}Service实现分页条件查询${Table}
        PageInfo<${Table}> pageInfo = ${table}Service.findPage(${table}, page, size, orderBy, asc);
        return CommonResult.success(pageInfo);
    }

    /***
     * ${Table} 根据id集合查询数据
     *
     * @param idList id集合
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}分页查询",notes = "分页查询${Table}方法详情")
    </#if>
    @PostMapping(value = "/listByIds" )
    public CommonResult<List<${Table}>> listByIds(<#if swagger==true>@ApiParam("listParam")</#if> @RequestBody List<Long> idList){
        //调用${Table}Service实现分页查询${Table}
        List<${Table}> pageInfo = ${table}Service.listByIds(idList);
        return CommonResult.success(pageInfo);
    }

    /***
     * 多条件搜索数据
     *
     * @param ${table}
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件查询", notes = "条件查询${Table}方法详情")
    </#if>
    @PostMapping(value = "/search" )
    public CommonResult<List<${Table}>> findList(@RequestBody <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = false)</#if> ${Table} ${table}){
        //调用${Table}Service实现条件查询${Table}
        List<${Table}> list = ${table}Service.findList(${table});
        return CommonResult.success(list);
    }

    /***
     * 根据ID删除数据
     *
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID删除",notes = "根据ID删除${Table}方法详情")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable ${keyType} id){
        //调用${Table}Service实现根据主键删除
        UserDto userDTO = SecurityUtil.getUserDTO();
        ${table}Service.delete(id ,userDTO);
        return CommonResult.success(null);
    }


    /***
     * 根据ID批量删除数据
     *
     * @param listParam 集合参数
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID批量删除",notes = "根据ID批量删除${Table}方法详情")
    </#if>
    @DeleteMapping(value = "/batch" )
    public CommonResult deleteBatch(<#if swagger==true>@ApiParam("listParam")</#if> @RequestBody ArrayBodyParam<Long> listParam){
        //调用${Table}Service实现根据主键删除
        UserDto userDTO = SecurityUtil.getUserDTO();
        ${table}Service.deleteBatch(listParam.getRows() ,userDTO);
        return CommonResult.success(null);
    }


    /***
     * 修改${Table}数据
     *
     * @param ${table}
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID修改",notes = "根据ID修改${Table}方法详情")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @Validated <#if swagger==true>@ApiParam(name = "${Table}对象", value = "传入JSON数据", required = true)</#if> ${Table} ${table},@PathVariable("id") ${keyType} id){
        UserDto userDTO = SecurityUtil.getUserDTO();
        //设置主键值
        ${table}.${keySetMethod}(id);
        ${table}Service.update(${table} ,userDTO);
        return CommonResult.success(null);
    }

    /***
     * 新增${Table}数据
     *
     * @param ${table}
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}添加",notes = "添加${Table}方法详情")
    </#if>
    @PostMapping
    public CommonResult add(@RequestBody @Validated <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = true)</#if> ${Table} ${table}){
        UserDto userDTO = SecurityUtil.getUserDTO();
        ${table}Service.add(${table} ,userDTO);
        return CommonResult.success(null);
    }

    /***
     * 根据ID查询${Table}数据
     *
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID查询",notes = "根据ID查询${Table}方法详情")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @GetMapping("/{id}")
    public CommonResult<${Table}> findById(@PathVariable ${keyType} id){
        //调用${Table}Service实现根据主键查询${Table}
        ${Table} ${table} = ${table}Service.findById(id);
        return CommonResult.success(${table});
    }

    /***
     * 查询${Table}全部数据
     *
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "查询所有${Table}",notes = "查询所${Table}有方法详情")
    </#if>
    @GetMapping
    public CommonResult<List<${Table}>> findAll(){
        //调用${Table}Service实现查询所有${Table}
        List<${Table}> list = ${table}Service.findAll();
        return CommonResult.success(list);
    }
}
