#version 330 core

in vec2 outTextureCoord;
out vec4 color;

uniform sampler2D sampler;

void main() {
    vec4 textureColor = texture(sampler, outTextureCoord);
    if(textureColor.w == 0){
        discard;
    }
    color = textureColor;
}
