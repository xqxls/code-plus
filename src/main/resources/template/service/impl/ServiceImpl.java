package ${package_service_impl};
import ${package_mapper}.${Table}Mapper;
import ${package_pojo}.${Table};
import ${package_service}.${Table}Service;
import com.xqxls.common.domain.UserDto;
import com.xqxls.common.exception.ApiException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
import java.util.Collections;

/**
 * ${tableComment} serviceImpl
 * ${TableName}
 *
 * @Author: ${Table}构建
 * @Description: ${Table}构建
 * @Date ${time}
 */
@Service
public class ${Table}ServiceImpl implements ${Table}Service {

    @Autowired
    private ${Table}Mapper ${table}Mapper;


    /**
     * ${Table}条件+分页查询
     * @param ${table} 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<${Table}> findPage(${Table} ${table}, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(${table});
        //执行搜索
        return new PageInfo<${Table}>(${table}Mapper.selectByExample(example));
    }


    /**
     * ${Table}条件+分页查询
     *
     * @param ${table}
     * @param page    页码
     * @param size    每页数量
     * @param orderBy 排序字段,可为null
     * @param asc     是否升序
     * @return
     */
    @Override
    public PageInfo<${Table}> findPage(${Table} ${table}, int page, int size, String orderBy , Boolean asc) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(${table}, orderBy,asc != null && asc);
        //执行搜索
        return new PageInfo<${Table}>(${table}Mapper.selectByExample(example));
    }

    /**
     * 根据id集合查询数据
     *
     * @param idList id集合
     * @return
     */
    @Override
    public List<${Table}> listByIds(List<Long> idList){
        if (idList.isEmpty()) {
            return Collections.emptyList();
        }
        //搜索条件构建
        Example example = new Example(${Table}.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel", 0);
        criteria.andEqualTo("isEnable", 1);
        criteria.andIn("id", idList);
        //执行搜索
        return ${table}Mapper.selectByExample(example);
    }

    /**
     * ${Table}条件查询
     * @param ${table}
     * @return
     */
    @Override
    public List<${Table}> findList(${Table} ${table}) {
        //构建查询条件
        Example example = createExample(${table});
        //根据构建的条件查询数据
        return ${table}Mapper.selectByExample(example);
    }



    /**
     * ${Table}构建查询对象
     * @param ${table}
     * @return
     */
    public Example createExample(${Table} ${table} ){
        return createExample(${table}, null, false);
    }

    /**
     * ${Table}构建查询对象
     * @param ${table}
     * @return
     */
    public Example createExample(${Table} ${table}, String orderBy , boolean asc) {
        Example example = new Example(${Table}.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if (orderBy != null) {
            if (asc) {
                example.orderBy(orderBy).asc();
            } else {
                example.orderBy(orderBy).desc();
            }
        }
        if(${table} != null) {
            <#list models as md>
            if(!StringUtils.isEmpty(${table}.get${md.upperName}())) {
                <#if (md.name?contains("title") || md.name?contains("name") || md.name?contains("Name"))>
                criteria.andLike("${md.name}","%"+${table}.get${md.upperName}()+"%");
                <#else>
                criteria.andEqualTo("${md.name}",${table}.get${md.upperName}());
                </#if>
            }
            </#list>
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(${keyType} id, UserDto userDto) {
        ${Table} ${table} = new ${Table}();
        ${table}.setId(id);
        ${table}.setIsDel(1);
        ${table}.setUpdateVal(userDto);
        ${table}Mapper.updateByPrimaryKeySelective(${table});
    }

    /***
     * 批量删除${Table}
     * @param idList  id集合
     * @param userDto 操作的用户信息
     */
    @Override
    public void deleteBatch(List<Long> idList, UserDto userDto) {
        ${Table} ${table} = new ${Table}();
        ${table}.setUpdateVal(userDto);
        ${table}.setIsDel(1);
        for(Long id : idList){
            ${table}.setId(id);
            ${table}Mapper.updateByPrimaryKeySelective(${table});
        }
    }

    /**
     * 修改${Table}
     * @param ${table}
     */
    @Override
    public void update(${Table} ${table} , UserDto userDto) {
        this.assertNotExists(${table});
        ${table}.setUpdateVal(userDto);
        ${table}Mapper.updateByPrimaryKeySelective(${table});
    }

    /**
     * 增加${Table}
     * @param ${table}
     */
    @Override
    public void add(${Table} ${table}, UserDto userDto) {
        ${table}.setId(null);
        this.assertNotExists(${table});
        ${table}.setDefaultVal(userDto);
        ${table}Mapper.insertSelective(${table});
    }

    /**
     * 根据ID查询${Table}
     * @param id
     * @return
     */
    @Override
    public ${Table} findById(${keyType} id) {
        if (id == null) {
            return null;
        }
        Example example = new Example(${Table}.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel", 0);
        criteria.andEqualTo("id", id);
        return ${table}Mapper.selectOneByExample(example);
    }

    /**
     * 查询${Table}全部数据
     * @return
     */
    @Override
    public List<${Table}> findAll() {
        return ${table}Mapper.selectByExample(this.createExample(null));
    }

    /**
     * 判断对象不存在
     *
     * @param ${table} ${tableComment}
     */
    private void assertNotExists(${Table} ${table}){
        Example example = new Example(${Table}.class);
        Example.Criteria criteria = example.createCriteria();
        // TODO 待完善重复条件
        criteria.andEqualTo("isDel" , 0);
        criteria.andNotEqualTo("id",${table}.getId());
        int count = ${table}Mapper.selectCountByExample(example);
        if (count > 0) {
            throw new ApiException("${tableComment}[" + "重复条件"+ "]已存在,请勿重复添加");
        }
    }
}
