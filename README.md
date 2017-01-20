# aws-todo-app

## Deploy with existing VPC

Replace following parameters with your own:
* `--stack-name`
* `ParameterKey=TableName`
* `ParameterKey=SubNet

### Create (mock version)
```
aws cloudformation create-stack --capabilities CAPABILITY_IAM --stack-name todo-app --template-body file://todo-app.yaml \
        --parameters ParameterKey=SoftwareVersion,ParameterValue=mock \
        ParameterKey=TableName,ParameterValue=todo-table \
        ParameterKey=SubNet,ParameterValue=10
```

### Update (latest version)
```
aws cloudformation update-stack --capabilities CAPABILITY_IAM --stack-name todo-app --template-body file://todo-app.yaml \
        --parameters ParameterKey=SoftwareVersion,ParameterValue=latest \
        ParameterKey=TableName,ParameterValue=todo-table \
        ParameterKey=SubNet,ParameterValue=10
```

## Deploy VPC
```
aws cloudformation create-stack --capabilities CAPABILITY_IAM --stack-name todo-app-vpc --template-body file://vpc-cfn.yaml
```

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

## Delete & describe
### Get stack information
```
aws cloudformation describe-stacks --stack-name todo-app
```

### Delete stack
```
aws cloudformation delete-stack --stack-name todo-app
```
