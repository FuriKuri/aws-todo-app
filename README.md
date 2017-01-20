# aws-todo-app

## Deploy with existing VPC
### Create
```
aws cloudformation create-stack --capabilities CAPABILITY_IAM --stack-name todo-app --template-body file://todo-app.yaml \
        --parameters ParameterKey=SoftwareVersion,ParameterValue=mock \
        ParameterKey=TableName,ParameterValue=todo-table \
        ParameterKey=SubNet,ParameterValue=10
```

### Update
```
aws cloudformation update-stack --capabilities CAPABILITY_IAM --stack-name todo-app --template-body file://todo-app.yaml \
        --parameters ParameterKey=SoftwareVersion,ParameterValue=latest \
        ParameterKey=TableName,ParameterValue=todo-table \
        ParameterKey=SubNet,ParameterValue=10
```

## Deploy
### Create
```
aws cloudformation create-stack --capabilities CAPABILITY_IAM --stack-name todo-app --template-body file://cfn.yaml \
        --parameters ParameterKey=SoftwareVersion,ParameterValue=mock \
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
