package ${package_feign};
import ${package_pojo}.${Table};
import com.github.pagehelper.PageInfo;
import com.xqxls.common.api.CommonResult;
import com.xqxls.common.domain.ArrayBodyParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;



/**
 * ${tableComment} feign
 * ${TableName}
 *
 * @Author: ${Table}构建
 * @Description: ${Table}构建
 * @Date ${time}
 */
@ApiIgnore
@FeignClient(name="${serviceName}")
@RequestMapping("/${table}")
public interface ${Table}Feign {

    /***
     * ${Table}分页条件搜索实现
     * @param ${table}
     * @param page 页码
     * @param size 每页数量
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo<${Table}>> findPage(@RequestBody ${Table} ${table}, @PathVariable("page")  int page, @PathVariable("size")  int size);

    /***
     * ${Table}分页搜索实现
     * @param idList id集合
     * @return
     */
    @PostMapping(value = "/listByIds" )
    CommonResult<List<${Table}>> listByIds(@RequestBody List<Long> idList);

    /***
     * 多条件搜索品牌数据
     * @param ${table}
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<${Table}>> findList(@RequestBody ${Table} ${table});

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable("id") ${keyType} id);


    /***
     * 根据ID批量删除数据
     * @param idList
     * @return
     */
    @DeleteMapping(value = "/batch" )
    CommonResult deleteBatch(@RequestBody ArrayBodyParam<Long> idList);

    /***
     * 修改${Table}数据
     * @param ${table}
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody ${Table} ${table},@PathVariable("id") ${keyType} id);

    /***
     * 新增${Table}数据
     * @param ${table}
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody ${Table} ${table});

    /***
     * 根据ID查询${Table}数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<${Table}> findById(@PathVariable("id") ${keyType} id);

    /***
     * 查询${Table}全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<${Table}>> findAll();
}