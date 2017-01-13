# aws-todo-app

## Deploy
### Create (mock version)
```
aws cloudformation create-stack --capabilities CAPABILITY_IAM --stack-name todo-app --template-body file://cfn.yaml \
        --parameters ParameterKey=SoftwareVersion,ParameterValue=mock \
        ParameterKey=TableName,ParameterValue=todo-table
```

### Update (latest version)
```
aws cloudformation update-stack --capabilities CAPABILITY_IAM --stack-name todo-app --template-body file://cfn.yaml \
        --parameters ParameterKey=SoftwareVersion,ParameterValue=latest \
        ParameterKey=TableName,ParameterValue=todo-table
```

### Get stack information
```
aws cloudformation describe-stacks --stack-name todo-app
```

### Delete stack
```
aws cloudformation delete-stack --stack-name todo-app
```
