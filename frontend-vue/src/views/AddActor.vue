<template>
    <div>
        <h1 class="titile">
            Add Actor
            </h1>

            <div class="field">
                <label class="label">First Name</label>
                <div class="control">
                    <input class="input" type="text" v-model="actors.firstName" placeholder="First Name" />
                    </div>
                 </div>
                        <div class="field">
                <label class="label">Last Name</label>
                <div class="control">
                    <input class="input" type="text" v-model="actors.lastName" placeholder="Last Name" />
                    </div>
                 </div>
                        <div class="field">
                <label class="label">Date Of Birth</label>
                <div class="control">
                    <input class="input" type="text" v-model="actors.dateOfBrith" placeholder="Date of Birth" />
                    </div>

                    <div class="filed is-group">
                        <p clas="control">
                            <button v-on:click="cancel" class="button">Cancel</button>
                        </p>
                        <p>
                            <button v-on:click="save" class="button is-primary">Save</button>
                            </p>
                    </div>
                 </div>
</template>

<script>
export default {
    name: 'AddActor',
    data: () => ({
        actor:{
            firstName: "",
            lastName: "",
            dateOfBrith: ""
        }
    }),
    methods:{
        cancel(){
            this.$router.push({path: '/actors'});
        },
        async save(){
            const response = await this.$http.post('http://localhost:8080/api/actors/', this.actor)
            console.log(reponse);
            if(response.status === 200){
                this.$router.push({path: '/actors'});
            }
        }
    }
    
}
</script>