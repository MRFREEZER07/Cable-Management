import MenuCard from './Components/MenuCard'
import SideBar from './Components/Shared/SideBar'
import { useEffect  } from 'react'
import { getAllCustomers } from './Services/Client'



function App() {

    useEffect(()=>{
        
        getAllCustomers().then(res=>{
          console.log(res);
         
          
        }).catch(e=>{
          console.log(e);
        })
       },[])

 return (
    <SideBar>
        <MenuCard></MenuCard>
    </SideBar>
    )
}

export default App
