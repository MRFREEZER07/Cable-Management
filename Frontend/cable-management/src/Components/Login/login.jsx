import {
    Flex,
    Box,
    FormControl,
    FormLabel,
    Input,
    Checkbox,
    Stack,
    Link,
    Button,
    Heading,
    Text,
    useColorModeValue,
    Alert,
    AlertIcon 
  } from '@chakra-ui/react';
  import {useField,Formik,Form} from "formik"
  import * as Yup from'yup'

  const MyTextInput = ({ label, ...props }) => {
    // useField() returns [formik.getFieldProps(), formik.getFieldMeta()]
    // which we can spread on <input>. We can use field meta to show an error
    // message if the field is invalid and it has been touched (i.e. visited)
    const [field, meta] = useField(props);
    return (
      <Box>
        <FormLabel htmlFor={props.id || props.name}>{label}</FormLabel>
        <Input className="text-input" {...field} {...props} />
        {meta.touched && meta.error ? (
          <Alert className="error" status={"error"} mt={2}>
          <AlertIcon></AlertIcon>
          {meta.error}</Alert>
        ) : null}
      </Box>
    );
  };

const LoginFrom =()=>{
    return(
        <Formik
        validateOnMount={true}
        validationSchema={
            Yup.object({
                username:Yup.string().required('username is required'),
                password:Yup.string().max(15).required('password is required')
            })
        }
        initialValues={{username:"",password:""}}
        onSubmit={
            (values,{setSubmitting})=>{
                alert(JSON.stringify(values,null,0))
            }
        }
        >
            {
                (isValid,isSubmitting)=>{
                    return  <Form>
                        <Stack spacing={"24px"}>
                        <MyTextInput name ={"username"}
                        placeholder={"Freezer"} 
                        />
                        <MyTextInput name ={"password"}
                        type={"password"}
                        placeholder={"Enter your password"} 
                        />
                        <Button type={"submit"} disabled={!isValid || isSubmitting}>Login</Button>
                        </Stack>
                    </Form>
                }
            }
        </Formik>
    )
}




  export default function Login() {
    return (
      <Flex
        minH={'100vh'}
        align={'center'}
        justify={'center'}
        bg={useColorModeValue('gray.50', 'gray.800')}>
        <Stack spacing={8} mx={'auto'} maxW={'lg'} py={12} px={6}>
          <Stack align={'center'}>
            <Heading fontSize={'4xl'}>Sign in to your account</Heading>
            <Text fontSize={'lg'} color={'gray.600'}>
              to enjoy all of our cool <Link color={'blue.400'}>features</Link> ✌️
            </Text>
          </Stack>
          <Box
            rounded={'lg'}
            bg={useColorModeValue('white', 'gray.700')}
            boxShadow={'lg'}
            p={8}>
            <Stack spacing={4}>
              <LoginFrom />
              </Stack>
            
          </Box>
        </Stack>
      </Flex>
    );
  }