<template>
    <div id = "header-component">
            <h1>Welcome to Doctor-Patient Connect</h1>
            <nav>
                <router-link class="btn" v-bind:to="{ name: 'appointment' }" v-if="$store.state.token != ''">my appointments</router-link>
                <router-link class="btn" v-bind:to="{ name: 'about' }" v-if="$store.state.token != ''">About</router-link>
                <a href="contact" class="btn">Contact Us</a>
                <a href="register.html" class="btn">Register</a>
                <router-link class="btn" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
                <router-link class="btn" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
                
            </nav>
        </div>
</template>

<style scoped>
#header-component {
    width: 100%;
    text-align: center;
    font-size: 24px;
    margin: auto;
    overflow: hidden;
    background: #50b3a2;
    color: #fff;
    padding-top: 30px;
    min-height: 70px;
    border-bottom: #e8491d 3px solid;
}

#header-component a {
    color: #fff;
    text-decoration: none;
    text-transform: uppercase;
    font-size: 20px;
}

#header-component ul {
    padding: 0;
    list-style: none;
}

#header-component li {
    display: inline;
    padding: 0 20px 0 20px;
}

#header-component h1 {
    margin-top: 0;
}

#header-component nav {
    float: right;
    margin-top: 10px;
}

#header-component .btn {
    display: inline-block;
    color: #fff;
    background: #e8491d;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 5px;
    margin-left: 10px;
}
</style>


