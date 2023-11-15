package ${package_service};

import ${package_pojo}.${Table};
import com.github.pagehelper.PageInfo;
import com.xqxls.common.domain.UserDto;
import java.util.List;

/**
 * ${tableComment} service
 * ${TableName}
 *
 * @Author: ${Table}构建
 * @Description: ${Table}构建
 * @Date ${time}
 */
public interface ${Table}Service {

    /***
     * ${Table}多条件分页查询
     * @param ${table}
     * @param page 页码
     * @param size 每页数量
     * @return
     */
    PageInfo<${Table}> findPage(${Table} ${table}, int page, int size);


    /***
     * BusinessUnitInfo多条件分页查询
     *
     * @param ${table}
     * @param page    页码
     * @param size    每页数量
     * @param orderBy 排序字段,可为null
     * @param asc     是否升序
     * @return
     */
    PageInfo<${Table}> findPage(${Table} ${table}, int page, int size , String orderBy, Boolean asc);

    /**
     * 根据id集合查询数据
     *
     * @param idList id集合
     * @return
     */
    List<${Table}> listByIds(List<Long> idList);

    /***
     * ${Table}多条件搜索方法
     * @param ${table}
     * @return
     */
    List<${Table}> findList(${Table} ${table});

    /***
     * 删除${Table}
     * @param id
     * @param userDto 操作的用户信息
     */
    void delete(${keyType} id, UserDto userDto);

    /***
     * 批量删除${Table}
     * @param idList  id集合
     * @param userDto 操作的用户信息
     */
    void deleteBatch( List<Long> idList, UserDto userDto);

    /***
     * 修改${Table}数据
     * @param ${table}
     */
    void update(${Table} ${table}, UserDto userDto);

    /***
     * 新增${Table}
     * @param ${table}
     */
    void add(${Table} ${table}, UserDto userDto);

    /**
     * 根据ID查询${Table}
     * @param id
     * @return
     */
     ${Table} findById(${keyType} id);

    /***
     * 查询所有${Table}
     * @return
     */
    List<${Table}> findAll();
}
