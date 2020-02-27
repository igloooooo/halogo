<template>
    <div class="modal-body">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <b-alert show variant="danger" v-if="authenticationError" >
                    <strong>Failed to convert!</strong> Please check your input.
                </b-alert>
            </div>
            <div class="col-md-8">
                <b-form role="form" v-on:submit.prevent="doConvert()">
                    <b-form-group label="Username"  label-for="username">
                        <b-form-input id="username" type="text" name="username" autofocus  placeholder="Your username" v-model="username"
                                      required>
                        </b-form-input>
                    </b-form-group>
                    <b-form-group label="Number"  label-for="password">
                        <b-form-input id="number" type="number" name="number" placeholder="Input the number (0 to 1000000)" v-model="number"
                                      step="0.01" min="0" max="1000000" required>
                        </b-form-input>
                    </b-form-group>
                    <div>
                        <b-button type="submit" variant="primary">Submit</b-button>
                    </div>
                </b-form>
                <p></p>
                <div>
                    <b-alert show variant="warning">
                        <b-link :to="'/login'" class="alert-link">Please login first</b-link>
                    </b-alert>
                </div>
                <div>
                    <b-alert show variant="warning">
                        <span>Please input you number (0 to 1000000) and click submit button</span>
                    </b-alert>
                </div>
            </div>
        </div>
        <div class="row justify-content-center" v-if="word">
            <div class="col-md-8">
                <b-card-group deck>
                    <b-card
                        header="Convert Result"
                        header-tag="header"
                        bg-variant="info"
                    >
                        <b-form role="form">
                            <b-form-group label="Username"  label-for="username">
                                <b-form-input type="text" aria-readonly="true" v-model="username">
                                </b-form-input>
                            </b-form-group>
                            <b-form-group label="Converted Number"  label-for="password">
                                <b-form-input aria-readonly="true" v-model="word">
                                </b-form-input>
                            </b-form-group>
                        </b-form>
                    </b-card>
                </b-card-group>
            </div>
        </div>
    </div>
</template>
<script lang="ts" src="./transform.components.ts">
</script>
