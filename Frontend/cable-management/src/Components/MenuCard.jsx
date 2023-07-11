import {SimpleGrid,Button,Card,CardFooter,Heading,CardHeader,CardBody,Text}  from '@chakra-ui/react';


export default function MenuCard(){
    return (
        <>
        <SimpleGrid spacing={4} templateColumns='repeat(auto-fill, minmax(200px, 1fr))'>
  <Card >
    <CardHeader>
      <Heading size='m'> VIEW ALL CUSTOMERS</Heading>
    </CardHeader>
    <CardBody>
      <Text>Shows all customers in a List</Text>
    </CardBody>
    <CardFooter>
      <Button>View here</Button>
    </CardFooter>
  </Card>
  <Card>
    <CardHeader>
      <Heading size='m'> DUE</Heading>
    </CardHeader>
    <CardBody>
      <Text>Shows customer with Due</Text>
    </CardBody>
    <CardFooter>
      <Button>View here</Button>
    </CardFooter>
  </Card>
  <Card>
    <CardHeader>
      <Heading size='m'> ADD NEW CUSTOMER</Heading>
    </CardHeader>
    <CardBody>
      <Text>Adds a  new customer to the List</Text>
    </CardBody>
    <CardFooter>
      <Button>View here</Button>
    </CardFooter>
  </Card>
  <Card>
    <CardHeader>
      <Heading size='m'> CANCEL DUE</Heading>
    </CardHeader>
    <CardBody>
      <Text>Cancels the due for a specific Customer</Text>
    </CardBody>
    <CardFooter>
      <Button>View here</Button>
    </CardFooter>
  </Card>
  <Card>
    <CardHeader>
      <Heading size='m'> HISTORY</Heading>
    </CardHeader>
    <CardBody>
      <Text>Shows Payment History of a specific Customer</Text>
    </CardBody>
    <CardFooter>
      <Button>View here</Button>
    </CardFooter>
  </Card>
  
</SimpleGrid>
</>
    )
}