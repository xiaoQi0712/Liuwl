import React from 'react'
import {
  Form,
  Input,
  Upload,
  Button,
  message,
  Icon,
  Select,
} from 'antd'

class DishesForm extends React.Component {
  render(){

    const { getFieldDecorator } = this.props.form;
    const formItemLayout = {
      labelCol: {
        xs: { span: 24 },
        sm: { span: 4 },
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 20 },
      },
    };
    const props = {
      name: 'file',
      action: 'http://134.175.154.93:8099/manager/file/upload',
      headers: {
        authorization: 'authorization-text',
      },
      onChange:(info)=> {
        if (info.file.status !== 'uploading') {
          console.log("change:",info.file, info.fileList);

          let resp = info.file.response.data;
          let id = "http://134.175.154.93:8888/"+resp.groupname+"/"+resp.id;
          // 将id设置到表单
          this.props.form.setFieldsValue({
            dishesImage:id
          })
        }
        if (info.file.status === 'done') {
          message.success(`${info.file.name} file uploaded successfully`);
        } else if (info.file.status === 'error') {
          message.error(`${info.file.name} file upload failed.`);
        }
      },
    };
    getFieldDecorator('dishesName')
    getFieldDecorator('dishesReferral')
    getFieldDecorator('dishesPrice')
    getFieldDecorator('dishesClassifyId')
    getFieldDecorator('dishesImage')
    return (
      <div className="DishesForm">
      <Form {...formItemLayout} className="login-form">
        <Form.Item  label="甜品名称">
          {getFieldDecorator('dishesName', {
            rules: [{ required: true, message: 'Please input your realname!' }],
          })(
            <Input placeholder="dishesName" />,
          )}
        </Form.Item>
        <Form.Item  label="甜品介绍">
          {getFieldDecorator('dishesReferral', {
            rules: [{ required: true, message: 'Please input your username!' }],
          })(
            <Input placeholder="dishesReferral" />,
          )}
        </Form.Item>
        <Form.Item  label="甜品价格">
          {getFieldDecorator('dishesPrice', {
            rules: [{ required: true, message: 'Please input your username!' }],
          })(
            <Input placeholder="dishesPrice" />,
          )}
        </Form.Item>
        <Form.Item  label="甜品分类">
        {getFieldDecorator('dishesClassifyId', {
            rules: [{ required: true, message: 'Please input your username!' }],
          })(
            <Select name="dishesClassifyId" placeholder="请选择甜品分类" >
                    {
                      this.props.classify.map((item)=>{
                        return (
                        <option value={item.classifyId} key={item.classifyId}>{item.classifyName}</option>
                        )
                      })
                    }
                  </Select>
          )}
        {/*  */}
        </Form.Item>
        <Form.Item label="甜品图片">
                    <Upload {...props}>
                      <Button>
                        <Icon type="upload" /> Click to Upload
                      </Button>
                    </Upload>
                  </Form.Item> 

        
      </Form>
      </div>
    )
  }
}

const mapPropsToFields = (props) =>{
  let obj = {};
  for(let key in props.dis){
    obj[key] = Form.createFormField({
      value: props.dis[key]
    })
  }
  return obj;
}
export default Form.create({
  mapPropsToFields
})(DishesForm);