
import React, {Component} from 'react'
import {actions} from "mirrorx";
import {Col, Row, FormControl, Label, Radio} from "tinper-bee";
import DatePicker from 'bee-datepicker';
import moment from "moment";
import Select from 'bee-select';
import FormList from 'components/FormList';
import FormError from 'components/FormError';
import SearchPanel from 'components/SearchPanel';
import FormControlPhone from 'components/FormControlPhone';
import RefCommon from 'components/RefCommon';
import {addSearchKey} from 'utils';

import './index.less'

const FormItem = FormList.Item;

const layoutOpt = null

class SearchArea extends Component {

    constructor(props) {
        super(props);
        this.state = {}

    }

    componentDidMount(){
        this.props.onRef(this)
    }

    /** 查询数据
     * @param {*} error 校验是否成功
     * @param {object} values 表单数据
     */
    search = () => {
        this.props.form.validateFields(async (err, values) => {
            const {table2Obj} = this.props;
            const {pageSize} = table2Obj;
            values.pageIndex = 0;  // 默认回到第一页
            values.pageSize = pageSize;
            addSearchKey(values);
            actions.masterDetailMany.updateState({searchParam: values}); // 将查询数据放在 model里
            await actions.masterDetailMany.loadList(values);
        });
    }

    /**
     * 清空 action里的搜索条件
     */
    reset = () => {
        this.props.form.resetFields();
        actions.masterDetailMany.updateState({searchParam: {}});
    }

    render() {
        const {form} = this.props;
        const {getFieldProps} = form;
        return (
            <SearchPanel
                className="small"
                form={form}
                reset={this.reset}
                search={this.search}>
                <FormList>
                              <FormItem>
        <Label >
            表编号2
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('table2_no', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.table2_no === 'undefined') ? "" : rowData.table2_no
,
                rules: [{
                    type:'string',required: true,pattern:/\S+/ig, message: '请输入表编号2',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ table2_no: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                              <FormItem>
        <Label >
            表编号1
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('table1_no', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.table1_no === 'undefined') ? "" : rowData.table1_no
,
                rules: [{
                    type:'string',required: true,pattern:/\S+/ig, message: '请输入表编号1',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ table1_no: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                              <FormItem>
        <Label >
            属性名
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('table2_name', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.table2_name === 'undefined') ? "" : rowData.table2_name
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入属性名',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ table2_name: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                </FormList>
            </SearchPanel>
        )
    }
}

export default FormList.createForm()(SearchArea)