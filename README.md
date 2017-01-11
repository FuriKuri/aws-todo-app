# aws-todo-app

## Deploy
### Create
```
aws cloudformation create-stack --capabilities CAPABILITY_IAM --stack-name todo-app --template-body file://cfn.yaml \
        --parameters ParameterKey=SoftwareVersion,ParameterValue=latest \
        ParameterKey=TableName,ParameterValue=todo-table
```

### Update
```
aws cloudformation update-stack --capabilities CAPABILITY_IAM --stack-name todo-app --template-body file://cfn.yaml \
        --parameters ParameterKey=SoftwareVersion,ParameterValue=latest \
        ParameterKey=TableName,ParameterValue=todo-table
```

### Get stack information
```
aws cloudformation describe-stacks --stack-name todo-app
```