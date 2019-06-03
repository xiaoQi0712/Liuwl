import React from 'react';
import './Dishes.css';
import DishesForm from './DishesForm';
import { Icon,message,Form,Button,Modal,Table,Divider,Input,Popconfirm } from 'antd';
import $ from 'jquery';
import TextArea from 'antd/lib/input/TextArea';

var delId=[];
class Dishes extends React.Component{

    constructor(){
        super();
        this.state = {
            classify:[], //菜品分类
            dishes:[],   //查询列表
            form:{
              classifyName:"",
              dishesId:"",
              dishesName:"",
              dishesReferral:"",
              dishesPrice:"",
              dishesImage:"",
              dishesClassifyId:""
            },
            visible: false,  //增加甜品
            twovisible:false, //增加分类
            updatavisible:false //修改
        }
    }
    componentDidMount(){
      //加载菜品分类
      this.loadClassifyName();
      //加载甜品信息
      this.loadDishes();
      // console.log($('tbody')[0].children);
    }

    // 事件处理器
    changeHandler = (event) =>{
      let name = event.target.name;
      let value = event.target.value;
      //alert(event.target.name);
      this.setState({
        form:{...this.state.form,...{[name]:value}}
      })
    }
    //提交分类信息
    submitClassifyHandler = (event) =>{
      
      let url = "http://localhost:8888/classify/add"
      $.post(url,this.state.form,()=>{
        //刷新页面
        this.loadDishes();
      })
      event.preventDefault();
      
      this.setState({
        twovisible : false,
        form : {
          dishesName:"",
        }
    })
    }
    saveFormRef = (form) => {
      console.log(form);
      this.setState({
        form
      })
    }
    //提交甜品信息
    submitDishesHandler = (event) =>{
     event.preventDefault();
    this.state.form.validateFields((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
        let url = "http://localhost:8888/dishes/AddDishes"
        $.post(url,values,(result)=>{
          // 提示成功
          message.success(result.message);
          // 关闭模态框
          this.setState({ visible: false, });
          // 刷新数据
          this.loadDishes();
        })
      }
    });
    }
    //修改
    submitDishesHandlers=(event)=>{
        let url = "http://localhost:8888/dishes/AddDishes"
      $.post(url,this.state.form,()=>{
        //刷新页面
        this.loadDishes();
      })
      event.preventDefault();

      this.setState({
        updatavisible:false,
        visible : false,
        form : {
          dishesName:"",
          dishesReferral:"",
          dishesPrice:"",
          dishesImage:"",
          dishesClassifyId:""
        }
    })
    }
    //加载菜品分类
    loadClassifyName(){
      let url = 'http://localhost:8888/classify/findClassifyName';
      $.get(url,({status,message,data})=>{
        if(status === 200){
          this.setState({
            "classify":data,
             form:{...this.state.form,...{dishesClassifyId:data[0].classifyId}}
            
          })
        }else{alert(message)}
      })
    }

    //查找所有菜品信息
    loadDishes(){
      let url = 'http://localhost:8888/dishes/findAll';
      $.get(url,({status,message,data})=>{
        if(status === 200){
          this.setState({
            "dishes":data
          })
        } else {alert (message)}
      })
    }
    //删除甜品信息
    showDataModal(id){
      let url = "http://localhost:8888/dishes/Delete?id="+id;
      $.get(url,({status,message,data})=>{
        if(status === 200){
          this.loadDishes();
        } else {alert (message)}
      })
    }
    //批量删除
    showbatchDelete(){
      let url = "http://localhost:8888/dishes/batchDelete"
      $.ajax(url,{
        type:'POST',
        contentType:'application/json',
        data:JSON.stringify(delId),
        success:()=>{
         this.loadDishes();
        }
      })
    }

    // 模态框
    showModal = () => {
        this.setState({
          visible: true,
        });
      };
    showmodal = () => {
        this.setState({
          twovisible: true,
        });
      };
      //修改甜品信息
      showUPdataModal(id)  {
        let url = 'http://localhost:8888/dishes/findById?id='+id;
        $.get(url,({status,message,data})=>{
          if(status === 200){
            this.setState({
              "form":data
            })
          } else {alert (message)}
        })

        this.setState({
          updatavisible: true,
        });
      };
      
      handleCancel = e => {
        console.log(e);
        this.setState({
          visible: false,
          twovisible:false,
          updatavisible:false,

          form : {
            classifyName:"",
            dishesName:"",
            dishesReferral:"",
            dishesPrice:"",
            dishesImage:"",
            dishesClassifyId:""
          }
        });    
      };
    
   render(){
    
     const columns = [
      
      {
        title: '甜品名称',
        dataIndex: 'dishesName',
        
      },
      {
        title: '甜品介绍',
        dataIndex: 'dishesReferral',
        
      },
      {
        title: '甜品价格',
        dataIndex: 'dishesPrice',
        
      },
      {
        title: '甜品分类',
        dataIndex: 'classify.classifyName',
        key:'dishesClassifyId'
      },
      {
        title: '甜品图片',
        render:(text,record)=>{
          return(
            <img style={{width:"50px"}} src={record.dishesImage}/>
          )
        }
      },
      {
        title: '操作',
        render: (text, record) => (
          <span>
            <Button onClick={this.showUPdataModal.bind(this,record.dishesId)}><Icon type="edit" /></Button>
            <Divider type="vertical" />
            <Popconfirm title="Are you sure？" okText="Yes" cancelText="No" onConfirm={this.showDataModal.bind(this,record.dishesId)}>
              <Button type="danger" ><Icon type="delete" /></Button>
            </Popconfirm>
            {/* <Button type="danger" onClick={this.showDataModal.bind(this,record.dishesId)}>删除</Button> */}
          </span>
        ),
      },
       
     ];
     const rowSelection = {
      onChange: (selectedRowKeys, selectedRows) => {
        console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
        delId=[];
        for(let i=0;i<selectedRows.length;i++){
         delId.push(selectedRows[i].dishesId);
        }
      },
    };

      let {dishes,classify,form} = this.state;
      const props = {
        name: 'file',
        action: 'http://134.175.154.93:8099/manager/file/upload ',
        headers: {
          authorization: 'authorization-text',
        },
        onChange:(info)=> {
          if (info.file.status !== 'uploading') {
            console.log(info.file, info.fileList);

            alert(info.file.response.data.id)
            let imgId = info.file.response.data;
            let ImgId = "http://134.175.154.93:8888/"+imgId.groupname+"/"+imgId.id;
            this.state.form = {
              dishesImage:ImgId
            }
          }
          if (info.file.status === 'done') {
            message.success(`${info.file.name} file uploaded successfully`);
          } else if (info.file.status === 'error') {
            message.error(`${info.file.name} file upload failed.`);
          }
        },
      };
       return(
        
        <div>
            <h2>甜品信息</h2>
            {/* {JSON.stringify(form)} */}
            <div className="btn">
            <Button className="btn-one" type="primary" onClick={this.showModal}>增加</Button>
            <Button className="btn-two" onClick={this.showmodal}>增加分类</Button>
            <Popconfirm title="Are you sure？" okText="Yes" cancelText="No" onConfirm={this.showbatchDelete.bind(this)}>
            <Button className="btn-three" type="danger">批量删除</Button>
            </Popconfirm>
            </div>
            <div className="table">
            {/* 表格 */}
            <Table size="small"
            rowKey="dishesId" rowSelection={rowSelection} columns={columns} dataSource={this.state.dishes} 
              />
            </div>
            {/* 增加 模态框 */}
            <Modal
                title="Basic Modal"
                visible={this.state.visible}
                onOk={this.submitDishesHandler}
                onCancel={this.handleCancel}
                >
                  <DishesForm ref={this.saveFormRef} dishes={this.state.form} classify={this.state.classify}/>
                {/* <form onSubmit={this.submitDishesHandler}>
                  
                  <FormItem label="甜品名称">
                  <Input size="large" name="dishesName" placeholder="请输入甜品名称" 
                  value={form.dishesName} onChange={this.changeHandler}/>
                  </FormItem>
                  <FormItem label="甜品介绍">
                  <TextArea size="large" name="dishesReferral" placeholder="请输入甜品介绍" 
                  value={form.dishesReferral} onChange={this.changeHandler}/>
                  </FormItem>
                  <FormItem label="甜品价格">
                  <Input size="large" name="dishesPrice" placeholder="请输入甜品价格" 
                  value={form.dishesPrice} onChange={this.changeHandler}/>
                  </FormItem> */}
                  {/* 甜品图片<Input size="large" name="dishesImage" placeholder="请上传甜品图片" 
                  value={form.dishesImage} onChange={this.changeHandler}/> */}
                  {/* <FormItem label="甜品分类">
                  <select name="dishesClassifyId" value={form.dishesClassifyId} onChange={this.changeHandler} >
                    {
                      classify.map((item)=>{
                        return (<option value={item.classifyId} key={item.classifyId}>{item.classifyName}</option>)
                      })
                    }
                  </select>
                  </FormItem> 
                  <FormItem>
                    <Upload {...props}>
                      <Button>
                        <Icon type="upload" /> Click to Upload
                      </Button>
                    </Upload>
                  </FormItem> 
                </form> */}
            </Modal>
            {/* 增加分类 模态框 */}
            <Modal
                title="Basic Modal"
                visible={this.state.twovisible}
                onOk={this.submitClassifyHandler}
                onCancel={this.handleCancel}
                >
                <form onSubmit={this.submitClassifyHandler}>
                甜品分类<Input size="large" name="classifyName" placeholder="请输入甜品分类" 
                  value={form.classifyName} onChange={this.changeHandler}/>
                </form>
            </Modal>
            {/* 编辑模态框 */}
            <Modal
                title="Basic Modal"
                visible={this.state.updatavisible}
                onOk={this.submitDishesHandlers}
                onCancel={this.handleCancel}
                >
                <form onSubmit={this.submitDishesHandlers}>
                甜品价格<Input name="dishesPrice" value={form.dishesPrice} onChange={this.changeHandler} 
                  size="large"  />
                甜品介绍<TextArea name="dishesReferral" value={form.dishesReferral} onChange={this.changeHandler} 
                  size="large"  />
                </form>
            </Modal>
            
        </div>
       )
   }
}
export default Form.create()(Dishes);